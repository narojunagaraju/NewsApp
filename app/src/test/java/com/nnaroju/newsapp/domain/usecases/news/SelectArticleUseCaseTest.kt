package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.data.local.NewsDao
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify

@RunWith(JUnit4::class)
class SelectArticleUseCaseTest {
    private lateinit var selectArticleUseCase: SelectArticleUseCase

    @Mock
    private lateinit var newsDao: NewsDao

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        selectArticleUseCase = SelectArticleUseCase(newsDao)
    }

    @Test
    fun `test invoke(article) on selectArticleUseCase interacts with dao`() {
        runBlocking {
            //Act
            selectArticleUseCase.invoke(anyString())

            //Assert
            verify(newsDao).getArticle(anyString())
        }
    }
}