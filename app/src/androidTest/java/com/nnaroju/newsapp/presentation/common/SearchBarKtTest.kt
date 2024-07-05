package com.nnaroju.newsapp.presentation.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performImeAction
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchBarKtTest {
    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun testSearchBarWithTextIsDisplayed() {
        composeRule.setContent {
            SearchBar(text = "Hello", readOnly = true, onValueChange = {}, onSearch = { })
        }
        composeRule.onNodeWithText("Hello").assertIsDisplayed()
    }

    @Test
    fun testSearchBarWithEmptyTextPlaceHolderTextIsDisplayed() {
        composeRule.setContent {
            SearchBar(text = "", readOnly = true, onValueChange = {}, onSearch = { })
        }
        composeRule.onNodeWithText("Search").assertIsDisplayed()
    }

    @Test
    fun testSearchBarWithSearchClickTriggersTheOnSearch() {
        var isSearchClicked = false
        composeRule.setContent {
            SearchBar(text = "", readOnly = true, onValueChange = {}, onSearch = { isSearchClicked = true })
        }
        composeRule.onNodeWithText("Search").performImeAction()

        assertTrue(isSearchClicked)
    }
}