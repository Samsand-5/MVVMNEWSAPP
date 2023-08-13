package com.example.mvvmnewsapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mvvmnewsapp.retrofit.NewsInterface
import com.example.mvvmnewsapp.retrofit.response.Article
import retrofit2.HttpException
import java.io.IOException
import com.example.mvvmnewsapp.Constants

const val STARTING_INDEX = 1

class NewsPagingSource(val newsInterface: NewsInterface) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val position = params.key ?: STARTING_INDEX

        return try {
            val data = newsInterface.getAllNews(
                "in",
                "business",
                Constants.API_KEY,
                position,
                params.loadSize
            )
            LoadResult.Page(
                data = data.articles,
                prevKey = if (params.key == STARTING_INDEX) null else position - 1,
                nextKey = if (data.articles.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }

    }

}