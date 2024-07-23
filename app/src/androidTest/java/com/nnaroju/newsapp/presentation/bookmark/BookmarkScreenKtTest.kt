package com.nnaroju.newsapp.presentation.bookmark

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BookmarkScreenKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testBookMarkTextIsDisplayed() {
        val bookmarkState = BookmarkState(
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
        composeRule.setContent {
            BookmarkScreen(state = bookmarkState, navigateToDetails = {})
        }

        composeRule.onNodeWithText("Bookmark").assertIsDisplayed()
    }

    @Test
    fun testArticleClickOnBookMarkScreen() {
        val bookmarkState = BookmarkState(
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
        var isNavigateToDetailsClicked = false
        composeRule.setContent {
            BookmarkScreen(
                state = bookmarkState,
                navigateToDetails = {
                    isNavigateToDetailsClicked = true
                },
                modifier = Modifier
            )
        }
        composeRule.onNodeWithTag("articlesList").performClick()

        assertTrue(isNavigateToDetailsClicked)
    }
}