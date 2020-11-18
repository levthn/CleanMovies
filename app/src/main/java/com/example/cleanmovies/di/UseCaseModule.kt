package com.example.cleanmovies.di

import com.example.cleanmovies.data.network.repository.MovieRepositoryImpl
import com.example.cleanmovies.domain.usecases.FetchMoviesFromServerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object UseCaseModule {
    @Singleton
    @Provides
    fun provideFetchMoviesFromServerUseCase(repositoryImpl: MovieRepositoryImpl): FetchMoviesFromServerUseCase = FetchMoviesFromServerUseCase(repositoryImpl)
    //Feedback: უსეცასე სინგლტონად რატ გინდა, ეს თვითონაც უდნა ჩაინჯექტდეს წესიტ რპოვიაიდერს გარესე
}