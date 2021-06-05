package com.example.newsapp.model

import com.example.newsapp.data.Response
import com.example.newsapp.data.Utils
import com.example.newsapp.network.NetworkUtils
import retrofit2.Call

class Repository(private val networkUtils: NetworkUtils) : RepoImpl {
    override fun getBreakingNews() = networkUtils.getNews("ru", Utils.API_KEY)
}