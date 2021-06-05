package com.example.newsapp.network

import com.example.newsapp.data.Response
import com.example.newsapp.data.Utils
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkUtils {

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<Response>

    companion object {
        private var retrofitService: NetworkUtils? = null
        fun getInstance(): NetworkUtils {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(NetworkUtils::class.java)
            }
            return retrofitService!!
        }
    }
}