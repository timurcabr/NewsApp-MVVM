package com.example.newsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "News"
)
data class News(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)