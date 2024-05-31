package com.nnaroju.newsapp.presentation.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ButtonKtTest {

    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun testNewsButtonWithTextIsDisplayed() {
        composeRule.setContent {
            NewsButton(text = "Next", onClick = {  })
        }

        composeRule.onNodeWithText("Next").assertIsDisplayed()

    }


    @Test
    fun testNewsTextButtonWithTextIsDisplayed() {
        composeRule.setContent {
            NewsTextButton(text = "Welcome", onClick = {  })
        }

        composeRule.onNodeWithText("Welcome").assertIsDisplayed()
    }
}