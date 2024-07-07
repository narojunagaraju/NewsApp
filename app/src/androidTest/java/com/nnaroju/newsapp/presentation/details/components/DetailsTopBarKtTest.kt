package com.nnaroju.newsapp.presentation.details.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsTopBarKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testTopAppBar() {
        composeRule.setContent {
            DetailsTopBar(
                onBrowsingClick = { },
                onShareClick = { },
                onBookmarkClick = { },
                onBackClick = { }
            )
        }
        composeRule.onNodeWithTag("topAppBar").assertIsDisplayed()
    }

    @Test
    fun testNavigationIconClick() {
        var isBackClicked = false

        composeRule.setContent {
            DetailsTopBar(
                onBrowsingClick = { },
                onShareClick = { },
                onBookmarkClick = { },
                onBackClick = { isBackClicked = true }
            )
        }
        composeRule.onNodeWithTag("navigationIcon").assertIsDisplayed()

        composeRule.onNodeWithTag("navigationIcon").performClick()

        assertTrue(isBackClicked)
    }

    @Test
    fun testSaveIconClick() {
        var isSaveClicked = false

        composeRule.setContent {
            DetailsTopBar(
                onBrowsingClick = { },
                onShareClick = { },
                onBookmarkClick = { isSaveClicked = true },
                onBackClick = { }
            )
        }
        composeRule.onNodeWithTag("saveIcon").assertIsDisplayed()

        composeRule.onNodeWithTag("saveIcon").performClick()

        assertTrue(isSaveClicked)
    }

    @Test
    fun testShareIconClick() {
        var isShareClicked = false

        composeRule.setContent {
            DetailsTopBar(
                onBrowsingClick = { },
                onShareClick = { isShareClicked = true },
                onBookmarkClick = { },
                onBackClick = { }
            )
        }
        composeRule.onNodeWithTag("shareIcon").assertIsDisplayed()

        composeRule.onNodeWithTag("shareIcon").performClick()

        assertTrue(isShareClicked)
    }

    @Test
    fun testSearchIconClick() {
        var isSearchClicked = false

        composeRule.setContent {
            DetailsTopBar(
                onBrowsingClick = { isSearchClicked = true },
                onShareClick = { },
                onBookmarkClick = { },
                onBackClick = { }
            )
        }
        composeRule.onNodeWithTag("searchIcon").assertIsDisplayed()

        composeRule.onNodeWithTag("searchIcon").performClick()

        assertTrue(isSearchClicked)
    }
}