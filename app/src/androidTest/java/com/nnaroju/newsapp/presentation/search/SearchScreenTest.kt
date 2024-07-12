package com.nnaroju.newsapp.presentation.search

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.paging.PagingData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchScreenTest {

    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun testSearchBarIsDisplayed() {
        val searchState = SearchState("Search")
        composeRule.setContent {
            SearchScreen(state = searchState, event = {}, navigateToDetails = {})
        }

        composeRule.onNodeWithText("Search").assertIsDisplayed()
    }

    @Test
    fun testSearchBarWithEventClick() {
        val searchState = SearchState("")
        var eventClicked = false

        composeRule.setContent {
            SearchScreen(state = searchState, event = {
                eventClicked = true
            }, navigateToDetails = {

            })
        }
        composeRule.onNodeWithText("Search").performTextInput("Hello")

        assertTrue(eventClicked)
    }

    @Test
    fun testSearchScreenWithArticlesDisplaysArticleList() {
        val searchState = SearchState(
            "", flowOf(
                PagingData.from(
                    listOf(
                        Article(
                            "Author",
                            "content",
                            "description",
                            "2024-07-01T15:17:57Z",
                            Source(id = "1", "name"),
                            "title", "url", "imageurl"
                        )
                    )
                )
            )
        )

        composeRule.setContent {
            SearchScreen(
                state = searchState,
                event = {},
                navigateToDetails = {},
                modifier = Modifier
            )
        }
        composeRule.onNodeWithTag("Articles").isDisplayed()
    }

}