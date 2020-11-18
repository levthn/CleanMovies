package com.example.cleanmovies.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanmovies.R
import com.example.cleanmovies.presentation.lists.MovieAdapter
import com.example.cleanmovies.presentation.vm.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

@AndroidEntryPoint
class HomeScreen : Fragment() {
    private lateinit var adapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModels()
    private val dissolve = CompositeDisposable()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)
        adapter = MovieAdapter()
        val moviesRV = view.findViewById<RecyclerView>(R.id.moviesRV)
        moviesRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        moviesRV.adapter = adapter
        val subscribe = viewModel.fetchMoviesFromServer().subscribe{
            adapter.setData(it)
        }

        dissolve.add(subscribe)

        return view
    }


}