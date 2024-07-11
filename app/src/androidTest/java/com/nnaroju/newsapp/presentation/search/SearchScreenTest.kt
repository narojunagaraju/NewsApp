package com.nnaroju.newsapp.presentation.search

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.paging.PagingData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import com.nnaroju.newsapp.utils.rememberLazyPagingItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.*
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


}