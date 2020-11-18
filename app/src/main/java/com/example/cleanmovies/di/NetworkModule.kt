package com.example.cleanmovies.di

import com.example.cleanmovies.app.Constants
import com.example.cleanmovies.data.network.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Provides
    fun provideNetwork(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()) ////Feedback: გსონი მოძველა ან moshi ან kotlinx.serialiation იხმარე
        .build()


    @Provides
    fun provideService(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)

    @Provides
    fun provideRXAdapterFactory():RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

}