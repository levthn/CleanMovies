package com.example.cleanmovies.domain.models
//Feedback:ფილდებს რანაირი ნეიმინგი აქვთ? https://kotlinlang.org/docs/reference/coding-conventions.html წაიკითხე
data class MovieDomainModel(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)