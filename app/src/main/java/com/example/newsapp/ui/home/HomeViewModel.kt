package com.example.newsapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.newsapp.model.Repository
import com.example.newsapp.network.NetworkUtils

class HomeViewModel : ViewModel() {

    private val repository = Repository(NetworkUtils.getInstance())

}