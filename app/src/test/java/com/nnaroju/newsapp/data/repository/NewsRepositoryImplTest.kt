package com.nnaroju.newsapp.data.repository

import com.nnaroju.newsapp.data.remote.NewsApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito

@RunWith(JUnit4::class)
class NewsRepositoryImplTest {

    @Mock
    private lateinit var newsApi: NewsApi

    private lateinit var newsRepositoryImpl: NewsRepositoryImpl

    @Before
    fun setUp() {
        newsApi = Mockito.mock(NewsApi::class.java)
    }

    @Test
    fun testGetNews() = runTest {
        newsRepositoryImpl = NewsRepositoryImpl(newsApi)
        val flowData = newsRepositoryImpl.getNews(listOf("Abc"))
        assertNotNull(flowData)
    }

    @Test
    fun testSearchNews() = runTest {
        newsRepositoryImpl = NewsRepositoryImpl(newsApi)
        val flowData = newsRepositoryImpl.searchNews("hello", listOf("Abc"))
        assertNotNull(flowData)
    }
}