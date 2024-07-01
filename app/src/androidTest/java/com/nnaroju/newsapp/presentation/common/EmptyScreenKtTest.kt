package com.nnaroju.newsapp.presentation.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.paging.LoadState
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.net.ConnectException
import java.net.SocketTimeoutException

@RunWith(AndroidJUnit4::class)
class EmptyScreenKtTest {

    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun testEmptyScreenWithErrorMessageNullDisplaysYouHaveNotSavedText() {
        composeRule.setContent {
            EmptyScreen()
        }
        composeRule.onNodeWithText("You haven't saved news so far!").assertIsDisplayed()
    }

    @Test
    fun testEmptyScreenWithSocketTimeOutErrorDisplaysServerUnavailableText() {
        composeRule.setContent {
            EmptyScreen(error = LoadState.Error(SocketTimeoutException()))
        }
        composeRule.onNodeWithText("Server unavailable").assertIsDisplayed()
    }

    @Test
    fun testEmptyScreenWithConnectErrorDisplaysInternetUnavailableText() {
        composeRule.setContent {
            EmptyScreen(modifier = Modifier.fillMaxSize(), error = LoadState.Error(ConnectException()))
        }
        composeRule.onNodeWithText("Internet unavailable").assertIsDisplayed()
    }

    @Test
    fun testEmptyScreenWithUnknownErrorDisplaysUnknownErrorText() {
        composeRule.setContent {
            EmptyScreen(modifier = Modifier.fillMaxSize(), error = LoadState.Error(UnknownError()))
        }
        composeRule.onNodeWithText("Unknown error").assertIsDisplayed()
    }
}