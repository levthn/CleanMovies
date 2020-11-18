package com.example.cleanmovies.domain.usecases

import com.example.cleanmovies.app.Constants
import com.example.cleanmovies.data.network.repository.MovieRepositoryImpl
import javax.inject.Inject
//Feedback: repositoryImpl: MovieRepositoryImpl-ის თუ აინჯექტებს რაღატ გინდა MovieRepository? დატა ლეიერზე დამიკოდებულებ გაქვს დომეინში
class FetchMoviesFromServerUseCase @Inject constructor(private val repositoryImpl: MovieRepositoryImpl) {
    fun fetchMoviesFromServer() = repositoryImpl.getMovies(Constants.key, 1)
}