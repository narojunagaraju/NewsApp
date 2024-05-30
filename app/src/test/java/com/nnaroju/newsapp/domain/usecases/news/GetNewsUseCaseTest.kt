package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.domain.respository.NewsRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify

@RunWith(JUnit4::class)
class GetNewsUseCaseTest {

    private lateinit var getNewsUseCase: GetNewsUseCase

    @Mock
    private lateinit var newsRepository: NewsRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getNewsUseCase = GetNewsUseCase(newsRepository)
    }

    @Test
    fun `test invoke on GetNewsUseCase interacts with newsRepository`() {
        runBlocking {
            //Arrange
            val list = emptyList<String>()

            //Act
            getNewsUseCase.invoke(list)

            //Assert
            verify(newsRepository).getNews(any())
        }
    }
}