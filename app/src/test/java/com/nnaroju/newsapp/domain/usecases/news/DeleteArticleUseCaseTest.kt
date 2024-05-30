package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.data.local.NewsDao
import com.nnaroju.newsapp.domain.model.Article
import kotlinx.coroutines.runBlocking
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
class DeleteArticleUseCaseTest {

    private lateinit var deleteArticleUseCase: DeleteArticleUseCase

    @Mock
    private lateinit var newsDao: NewsDao

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        deleteArticleUseCase = DeleteArticleUseCase(newsDao)
    }

    @Test
    fun `test invoke(article) on deleteUseCase interacts with dao`() = runBlocking {
        //Arrange
        val article = Mockito.mock(Article::class.java)

        //Act
        deleteArticleUseCase.invoke(article)

        //Assert
        verify(newsDao).delete(any())
    }
}