package com.nnaroju.newsapp.presentation.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.nnaroju.newsapp.domain.model.Article

@Composable
fun ArticlesList(
    articles: List<Article>,
    onClick: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    if (articles.isEmpty()) {
        EmptyScreen(modifier.fillMaxSize())
    } else {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(all = 4.dp)
        ) {
            items(count = articles.size) { index ->
                val article = articles[index]
                ArticleCard(article = article, onClick = { onClick(article) })
            }
        }
    }


}


@Composable
fun ArticlesList(
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    val handlePagingResult = handlePagingResult(articles = articles)

    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(all = 4.dp)
        ) {
            items(count = articles.itemCount) {
                articles[it]?.let { article ->
                    ArticleCard(article = article, onClick = { onClick(article) })
                }
            }
        }
    }
}


@Composable
fun handlePagingResult(
    articles: LazyPagingItems<Article>,
    modifier: Modifier = Modifier
): Boolean {

    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            Log.e("TAG", "handlePagingResult: $error")
            EmptyScreen(modifier = Modifier.fillMaxSize())
            false
        }

        articles.itemCount == 0 -> {
            EmptyScreen(
                error = error,
                modifier = Modifier.fillMaxSize()
            )
            false
        }

        else -> {
            true
        }
    }

}

@Composable
private fun ShimmerEffect(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = modifier.padding(horizontal = 30.dp)
            )
        }
    }
}