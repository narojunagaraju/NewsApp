package com.nnaroju.newsapp.presentation.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OnboardingScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testOnboardingFlow() {

        val event = mutableStateOf<OnboardingEvent?>(null)

        composeTestRule.setContent {
            OnboardingScreen(
                event = { onboardingEvent -> event.value = onboardingEvent },
                modifier = Modifier.fillMaxSize()
            )
        }

        //verifying the first page visibility
        composeTestRule.onNodeWithText("Home").assertIsDisplayed()
        composeTestRule.onNodeWithText("Next").performClick()

        //verifying the second page visibility
        composeTestRule.onNodeWithText("Favorites").assertIsDisplayed()
        composeTestRule.onNodeWithText("Back").assertIsDisplayed()
        composeTestRule.onNodeWithText("Back").performClick()

        //verifying the first page visibility
        composeTestRule.onNodeWithText("Home").assertIsDisplayed()
        composeTestRule.onNodeWithText("Next").performClick()

        //verifying the second page visibility
        composeTestRule.onNodeWithText("Favorites").assertIsDisplayed()
        composeTestRule.onNodeWithText("Next").performClick()

        //verifying the last page visibility
        composeTestRule.onNodeWithText("Bookmarks").assertIsDisplayed()
        composeTestRule.onNodeWithText("Get Started").assertIsDisplayed()
        composeTestRule.onNodeWithText("Get Started").performClick()


        assert(event.value == OnboardingEvent.SaveAppEntry)
    }

}