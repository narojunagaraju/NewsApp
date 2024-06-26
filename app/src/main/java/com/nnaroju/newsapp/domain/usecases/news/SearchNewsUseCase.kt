package com.nnaroju.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.respository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}