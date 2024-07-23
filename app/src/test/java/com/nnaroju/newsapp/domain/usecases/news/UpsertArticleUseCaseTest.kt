package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.data.local.NewsDao
import com.nnaroju.newsapp.domain.model.Article
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify

@RunWith(JUnit4::class)
class UpsertArticleUseCaseTest {

    @Mock
    private lateinit var newsDao: NewsDao

    private lateinit var upsertArticleUseCase: UpsertArticleUseCase


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        upsertArticleUseCase = UpsertArticleUseCase(newsDao)
    }

    @Test
    fun `test invoke(article) on UpsertArticleUseCase interacts with dao`() = runTest {
        val article = Mockito.mock(Article::class.java)
        //Act
        upsertArticleUseCase.invoke(article)

        //Assert
        verify(newsDao).upsert(any())
    }
}