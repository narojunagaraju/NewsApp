package com.nnaroju.newsapp.presentation.home

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.paging.compose.LazyPagingItems
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import com.nnaroju.newsapp.utils.rememberLazyPagingItems
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testHomeScreen() {
        val articlesList = List(11) {
            Article(
                "Author $it",
                "content $it",
                "description $it",
                "2024-07-01T15:17:57Z",
                Source(id = "$it", "name $it"),
                "title $it", "url $it", "imageurl $it"
            )
        }
        composeRule.setContent {
            val articles: LazyPagingItems<Article> = rememberLazyPagingItems(articlesList, false)
            HomeScreen(
                articles = articles,
                navigateToSearch = { },
                navigateToDetails = {},
                modifier = Modifier
            )
        }
        composeRule.onNodeWithText("Top News").assertIsDisplayed()
    }

    @Test
    fun testHomeScreenWithClickOnArticle() {
        val articlesList = listOf(
            Article(
                "Author",
                "content",
                "description",
                "2024-07-01T15:17:57Z",
                Source(id = "1", "name"),
                "title", "url", "imageurl"
            )
        )

        var isNavigateToDetailsClicked = false

        composeRule.setContent {
            val articles: LazyPagingItems<Article> = rememberLazyPagingItems(articlesList, false)
            HomeScreen(
                articles = articles,
                navigateToSearch = { },
                navigateToDetails = { isNavigateToDetailsClicked = true }
            )
        }

        composeRule.onNodeWithTag("ArticlesList").performClick()

        assertTrue(isNavigateToDetailsClicked)
    }

    @Test
    fun testHomeScreenWithSearchBarOnClick() {
        var isNavigateToSearchClicked = false

        composeRule.setContent {
            val articles: LazyPagingItems<Article> = rememberLazyPagingItems(emptyList(), false)
            HomeScreen(
                articles = articles,
                navigateToSearch = {
                    isNavigateToSearchClicked = true
                },
                navigateToDetails = { }
            )
        }

        composeRule.onNodeWithTag("searchBar").performClick()

        assertTrue(isNavigateToSearchClicked)
    }
}