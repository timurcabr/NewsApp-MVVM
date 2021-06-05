package com.example.newsapp.model

import com.example.newsapp.data.Response
import retrofit2.Call

interface RepoImpl {
    fun getBreakingNews() : Call<Response>
}