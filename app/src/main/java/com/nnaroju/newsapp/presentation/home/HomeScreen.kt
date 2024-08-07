package com.nnaroju.newsapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.nnaroju.newsapp.R
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.presentation.common.ArticlesList
import com.nnaroju.newsapp.presentation.common.SearchBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    val title by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items.slice(
                    IntRange(start = 0, endInclusive = 9)
                ).joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = modifier
    ) {
        Text(
            text = "Top News",
            modifier = Modifier.padding(horizontal = 24.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        SearchBar(
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = { },
            onClick = {
                navigateToSearch()
            },
            modifier = Modifier.testTag("searchBar")
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = title, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .basicMarquee()
                .testTag("title"),
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(24.dp))

        ArticlesList(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .testTag("ArticlesList"),
            articles = articles, onClick = {
                navigateToDetails(it)
            }
        )
    }
}