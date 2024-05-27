package com.nnaroju.newsapp.presentation.bookmark

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    var bookMarkState = mutableStateOf(BookmarkState())
        private set

    init {
        getArticles()
    }

    private fun getArticles() {
        newsUseCases.selectArticlesUseCase().onEach {
            bookMarkState.value = bookMarkState.value.copy(articles = it)
        }.launchIn(viewModelScope)
    }

}