package com.nnaroju.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.respository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}