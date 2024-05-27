package com.nnaroju.newsapp.presentation.bookmark

import com.nnaroju.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)