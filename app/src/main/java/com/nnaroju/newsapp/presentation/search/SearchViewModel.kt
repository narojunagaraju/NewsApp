package com.nnaroju.newsapp.presentation.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    var state = mutableStateOf(SearchState())
        private set

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                state.value = state.value.copy(searchQuery = event.searchQuery)
            }

            is SearchEvent.SearchNews -> {
                SearchNews()
            }
        }
    }


    fun SearchNews() {
        val articles = newsUseCases.searchNews(
            searchQuery = state.value.searchQuery,
            sources = listOf("abc-news", "bbc-news", "business-insider")
        ).cachedIn(viewModelScope)
        state.value = state.value.copy(articles = articles)
    }
}