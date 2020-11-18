package com.example.cleanmovies.domain.repository


import com.example.cleanmovies.domain.models.MovieDomainModel
import io.reactivex.Observable

interface MovieRepository {
    fun getMovies(key: String, page: Int): Observable<List<MovieDomainModel>>
}