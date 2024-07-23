package com.nnaroju.newsapp.presentation.bookmark

import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases
import com.nnaroju.newsapp.domain.usecases.news.SelectArticlesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class BookmarkViewModelTest {

    @Mock
    private lateinit var newsUseCases: NewsUseCases

    private val dispatcher = StandardTestDispatcher()

    private lateinit var bookmarkViewModel: BookmarkViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
    }


    @Test
    fun testGetArticles() {
        val selectArticleUseCase = Mockito.mock(SelectArticlesUseCase::class.java)
        Mockito.`when`(newsUseCases.selectArticlesUseCase).thenReturn(selectArticleUseCase)
        val articles = listOf(
            Article(
                "Author",
                "content",
                "description",
                "2024-07-01T15:17:57Z",
                Source(id = "1", "name"),
                "title", "url", "imageurl"
            )
        )
        Mockito.`when`(selectArticleUseCase.invoke()).thenReturn(flowOf(articles))

        runTest {
            bookmarkViewModel = BookmarkViewModel(newsUseCases)
        }

        assertEquals(1, bookmarkViewModel.bookMarkState.value.articles.size)
    }
}