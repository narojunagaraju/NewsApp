package com.nnaroju.newsapp.presentation.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.paging.compose.LazyPagingItems
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import com.nnaroju.newsapp.utils.rememberLazyPagingItems
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArticlesListTest {

    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun testArticlesListWithEmptyArticlesDisplaysEmptyScreen() {
        composeRule.setContent {
            ArticlesList(articles = emptyList(), onClick = {})
        }

        composeRule.onNodeWithText("You haven't saved news so far!").assertIsDisplayed()
    }


    @Test
    fun testArticlesListWithArticlesDisplaysArticleCards() {
        composeRule.setContent {
            ArticlesList(articles = listOf(
                Article(
                    "Author",
                    "content",
                    "description",
                    "2024-07-01T15:17:57Z",
                    Source(id = "1", "name"),
                    "title", "url", "imageurl"
                )
            ), onClick = {})
        }

        composeRule.onNodeWithText("title").assertIsDisplayed()
    }

    @Test
    fun testArticlesListWithPagingArticlesDisplaysArticleCards() {
        val articles = listOf(
            Article(
                "Author",
                "content",
                "description",
                "2024-07-01T15:17:57Z",
                Source(id = "1", "name"),
                "title", "url", "imageurl"
            )
        )
        composeRule.setContent {
            val articles: LazyPagingItems<Article> = rememberLazyPagingItems(articles)
            ArticlesList(articles = articles, onClick = {} )
        }

        composeRule.onNodeWithText("title").assertIsDisplayed()
    }

}