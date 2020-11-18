package com.example.cleanmovies.di

import com.example.cleanmovies.data.network.repository.MovieRepositoryImpl
import com.example.cleanmovies.data.network.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object MoviesRepoModule {
    @Singleton
    @Provides
    fun provideMovieRepo(movieRequest:MovieService):MovieRepositoryImpl = MovieRepositoryImpl(movieRequest)
}