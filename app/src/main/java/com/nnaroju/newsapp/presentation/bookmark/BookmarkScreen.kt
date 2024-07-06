package com.nnaroju.newsapp.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.presentation.common.ArticlesList

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigateToDetails: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(horizontal = 24.dp)) {
        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(24.dp))
        ArticlesList(articles = state.articles, onClick = {
            navigateToDetails(it)
        })
    }
}