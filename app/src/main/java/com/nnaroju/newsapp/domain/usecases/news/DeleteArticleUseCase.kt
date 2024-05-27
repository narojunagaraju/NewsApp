package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.data.local.NewsDao
import com.nnaroju.newsapp.domain.model.Article

class DeleteArticleUseCase(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article) {
        newsDao.delete(article)
    }
}