package com.example.cleanmovies.data.network.service


import com.example.cleanmovies.data.network.dto.MovieDTO
import com.example.cleanmovies.data.network.dto.ResponseDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieService {
    @GET("popular")
    fun getMovies(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Observable<ResponseDTO>
}

