package com.nnaroju.newsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.presentation.common.ArticlesList
import com.nnaroju.newsapp.presentation.common.SearchBar

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(top = 24.dp)
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchNews) })

        Spacer(modifier = Modifier.padding(24.dp))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(
                articles = articles,
                modifier = Modifier.padding(horizontal = 24.dp),
                onClick = {
                    navigateToDetails(it)
                }
            )
        }
    }

}