package com.nnaroju.newsapp.presentation.search

import androidx.paging.PagingData
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases
import com.nnaroju.newsapp.domain.usecases.news.SearchNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class SearchViewModelTest {

    @Mock
    lateinit var newsUseCases: NewsUseCases

    private lateinit var searchViewModel: SearchViewModel

    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockitoAnnotations.openMocks(this)
        searchViewModel = SearchViewModel(newsUseCases)
        Mockito.reset(newsUseCases)
    }


    @After
    fun cleanUp() {
        Dispatchers.resetMain()
    }


    @Test
    fun testOnEventWithUpdateSearchQuery() {
        searchViewModel.onEvent(SearchEvent.UpdateSearchQuery("hello"))

        assertEquals("hello", searchViewModel.state.value.searchQuery)
    }

    @Test
    fun testOnEventWithSearchNews() {
        //Arrange
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
        val searchNewsUseCase = Mockito.mock(SearchNewsUseCase::class.java)
        Mockito.`when`(newsUseCases.searchNews).thenReturn(searchNewsUseCase)
        Mockito.`when`(newsUseCases.searchNews(any(), any())).thenReturn(articles)

        //Act
        searchViewModel.onEvent(SearchEvent.SearchNews)

        //Assert
        assertNotNull(searchViewModel.state.value.articles)
    }

}