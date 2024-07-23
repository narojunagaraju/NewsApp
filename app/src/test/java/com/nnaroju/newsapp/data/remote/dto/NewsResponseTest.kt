package com.nnaroju.newsapp.data.remote.dto

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NewsResponseTest {

    @Test
    fun testNewsResponseVariables() {
        val newsResponse = NewsResponse(arrayListOf(), "true", 1)
        assertTrue(newsResponse.articles.isEmpty())
        assertTrue(newsResponse.status == "true")
        assertTrue(newsResponse.totalResults == 1)
    }
}