package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.data.local.NewsDao
import com.nnaroju.newsapp.domain.model.Article

class SelectArticleUseCase(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article? {
        return newsDao.getArticle(url)
    }
}