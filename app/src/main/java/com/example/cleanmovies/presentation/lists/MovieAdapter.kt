package com.example.cleanmovies.presentation.lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanmovies.R
import com.example.cleanmovies.app.Constants
import com.example.cleanmovies.domain.models.MovieDomainModel

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies = emptyList<MovieDomainModel>()


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        Glide.with(holder.itemView.context).load(Constants.image_url+movie.poster_path)
            .into(holder.itemView.findViewById(R.id.posterIV))
        holder.itemView.findViewById<TextView>(R.id.descriptionTV).text = movie.overview
        holder.itemView.findViewById<TextView>(R.id.titleTV).text = movie.original_title




    }

    fun setData(list: List<MovieDomainModel>) {
        movies = list
        notifyDataSetChanged()
    }
}