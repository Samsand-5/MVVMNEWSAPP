package com.example.mvvmnewsapp.retrofit.response

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)