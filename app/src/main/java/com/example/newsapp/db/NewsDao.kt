package com.example.newsapp.db

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.newsapp.data.News

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(news: News): Long

    @Query("SELECT * FROM News")
    fun getAllNews() : MutableLiveData<List<News>>

    @Delete
    suspend fun delete(news: News)
}