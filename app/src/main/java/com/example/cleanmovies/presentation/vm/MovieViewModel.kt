package com.example.cleanmovies.presentation.vm

import android.util.Log.d
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.cleanmovies.app.Constants
import com.example.cleanmovies.data.network.repository.MovieRepositoryImpl
import com.example.cleanmovies.domain.models.MovieDomainModel
import com.example.cleanmovies.domain.usecases.FetchMoviesFromServerUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieViewModel @ViewModelInject constructor(private val fetchMoviesFromServerUseCase: FetchMoviesFromServerUseCase) :
    ViewModel() {
    fun fetchMoviesFromServer(): Observable<List<MovieDomainModel>> =
        fetchMoviesFromServerUseCase.fetchMoviesFromServer()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                d("errorMessage", it.message.toString())
            }

}