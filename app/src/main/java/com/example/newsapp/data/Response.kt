package com.example.newsapp.data

data class Response(
    val status: String,
    val totalResults: Int,
    val articles: List<News>
)
