package com.example.newsapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.News
import com.example.newsapp.databinding.NewsItemBinding

class NewsAdapter(
    private val context: Context,
    private val newsList: List<News>,
    private val listener: OnNewsClickListener
) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    inner class NewsHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root), OnNewsClickListener {
        override fun onItemClick(position: Int) {
            listener.onItemClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        with(holder) {
            binding.apply {
                newsTitle.text = newsList[position].title
                newsDesc.text = newsList[position].description
                newsSource.text = newsList[position].source.name
                Glide.with(context).load(newsList[position].urlToImage).into(newsPoster)
            }
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}

interface OnNewsClickListener {
    fun onItemClick(position: Int)
}