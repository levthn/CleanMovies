package com.example.cleanmovies.data.network.repository

import com.example.cleanmovies.app.Constants
import com.example.cleanmovies.data.network.service.MovieService
import com.example.cleanmovies.data.mappers.toDomainModel
import com.example.cleanmovies.domain.models.MovieDomainModel
import com.example.cleanmovies.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val movieRequest: MovieService) :
    MovieRepository {
    override fun getMovies(key: String, page: Int): Observable<List<MovieDomainModel>> {
        return movieRequest.getMovies(Constants.key, 1).map {
            it.results.map {
                it.toDomainModel()
            }
        }
    }
}