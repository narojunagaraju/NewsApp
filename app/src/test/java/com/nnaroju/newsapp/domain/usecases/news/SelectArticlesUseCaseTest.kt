package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.data.local.NewsDao
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

@RunWith(JUnit4::class)
class SelectArticlesUseCaseTest {
    private lateinit var selectArticlesUseCase: SelectArticlesUseCase

    @Mock
    lateinit var newsDao: NewsDao

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        selectArticlesUseCase = SelectArticlesUseCase(newsDao)
    }

    @Test
    fun `test invoke(article) on selectArticlesUseCase interacts with dao`() = runTest {
        //Act
        selectArticlesUseCase.invoke()

        //Assert
        verify(newsDao).getArticles()
    }

}