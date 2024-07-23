package com.nnaroju.newsapp.domain.usecases.news

import com.nnaroju.newsapp.domain.respository.NewsRepository
import kotlinx.coroutines.test.runTest
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
class SearchNewsUseCaseTest {
    private lateinit var searchNewsUseCase: SearchNewsUseCase

    @Mock
    lateinit var newsRepository: NewsRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        searchNewsUseCase = SearchNewsUseCase(newsRepository)
    }

    @Test
    fun `test invoke on SearchNewsUseCase interacts with newsRepository`() = runTest {
        //Arrange
        val list = emptyList<String>()

        //Act
        searchNewsUseCase.invoke("", list)

        //Assert
        verify(newsRepository).searchNews(anyString(), any())
    }
}