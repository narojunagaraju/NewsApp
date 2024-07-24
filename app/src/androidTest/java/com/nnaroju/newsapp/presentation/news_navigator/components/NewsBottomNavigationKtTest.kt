package com.nnaroju.newsapp.presentation.news_navigator.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsBottomNavigationKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testBottomNavigationItems() {
        val bottomNavigationItems = listOf(
            BottomNavigationItem(imageVector = Icons.Default.Home, "Home"),
            BottomNavigationItem(imageVector = Icons.Default.Search, "Search"),
            BottomNavigationItem(imageVector = Icons.Default.Save, "Bookmark")
        )

        composeRule.setContent {
            NewsBottomNavigation(
                items = bottomNavigationItems,
                selected = 0,
                onItemClick = {},
                modifier = Modifier
            )
        }
        composeRule.onNodeWithText(bottomNavigationItems[0].text).assertIsDisplayed()
        composeRule.onNodeWithText(bottomNavigationItems[0].text).performClick()
        composeRule.onNodeWithText(bottomNavigationItems[1].text).assertIsDisplayed()
        composeRule.onNodeWithText(bottomNavigationItems[1].text).performClick()
        composeRule.onNodeWithText(bottomNavigationItems[2].text).assertIsDisplayed()
    }

    @Test
    fun testBottomNavigationItemsAreNotDisplayed() {
        composeRule.setContent {
            NewsBottomNavigation(items = emptyList(), selected = 0, onItemClick = {})
        }

        composeRule.onNodeWithText("Home").assertIsNotDisplayed()
    }

}

