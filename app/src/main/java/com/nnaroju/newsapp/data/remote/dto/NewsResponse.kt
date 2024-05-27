package com.nnaroju.newsapp.data.remote.dto

import com.nnaroju.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)