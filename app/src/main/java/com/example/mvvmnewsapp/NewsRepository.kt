package com.example.mvvmnewsapp

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.mvvmnewsapp.paging.NewsPagingSource
import com.example.mvvmnewsapp.retrofit.NewsInterface
import com.example.mvvmnewsapp.retrofit.response.Article

class NewsRepository(val newsInterface: NewsInterface) {
    fun getAllNewsStream(): LiveData<PagingData<Article>> = Pager(
        config = PagingConfig(
            20,
            5,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            NewsPagingSource(newsInterface)
        }
    ).liveData
}