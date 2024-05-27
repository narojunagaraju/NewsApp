package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.data.local.NewsDao
import com.nnaroju.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticlesUseCase(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}