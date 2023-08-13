package com.example.mvvmnewsapp.retrofit

import com.example.mvvmnewsapp.retrofit.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsInterface {

    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsResponse
}