package com.nnaroju.newsapp.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNewsUseCase,
    val searchNews: SearchNewsUseCase,
    val upsertArticleUseCase: UpsertArticleUseCase,
    val deleteArticleUseCase: DeleteArticleUseCase,
    val selectArticlesUseCase: SelectArticlesUseCase,
    val selectArticleUseCase: SelectArticleUseCase
)