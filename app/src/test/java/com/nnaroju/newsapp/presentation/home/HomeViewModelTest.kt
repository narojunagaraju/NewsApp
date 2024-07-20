package com.nnaroju.newsapp.presentation.home

import androidx.paging.PagingData
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import com.nnaroju.newsapp.domain.usecases.news.GetNewsUseCase
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any


@RunWith(JUnit4::class)
class HomeViewModelTest {

    @Mock
    private lateinit var newsUseCases: NewsUseCases

    @Mock
    private lateinit var getNewsUseCase: GetNewsUseCase

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetNews() {
        //Arrange
        runTest {
            val articles = flowOf(
                PagingData.from(
                    listOf(
                        Article(
                            "Author",
                            "content",
                            "description",
                            "2024-07-01T15:17:57Z",
                            Source(id = "1", "name"),
                            "title", "url", "imageurl"
                        )
                    )
                )
            )
            Mockito.`when`(newsUseCases.getNews).thenReturn(getNewsUseCase)
            Mockito.`when`(getNewsUseCase.invoke(any())).thenReturn(articles)

            homeViewModel = HomeViewModel(newsUseCases)
        }

        //Assert
        assertNotNull(homeViewModel.news)
    }
}