package com.example.mvvmnewsapp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.mvvmnewsapp.retrofit.response.Article

class NewsViewModel @ViewModelInject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    val list: LiveData<PagingData<Article>> = newsRepository.getAllNewsStream()

}