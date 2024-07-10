package com.nnaroju.newsapp.presentation.details.components

import com.nnaroju.newsapp.data.local.NewsDao
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.usecases.news.DeleteArticleUseCase
import com.nnaroju.newsapp.domain.usecases.news.NewsUseCases
import com.nnaroju.newsapp.domain.usecases.news.SelectArticleUseCase
import com.nnaroju.newsapp.domain.usecases.news.UpsertArticleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class DetailsViewModelTest {

    @Mock
    lateinit var newsUseCases: NewsUseCases

    private lateinit var detailsViewModel: DetailsViewModel

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockitoAnnotations.openMocks(this)
        detailsViewModel = DetailsViewModel(newsUseCases)
        Mockito.reset(newsUseCases)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
    }


    @Test
    fun testOnEventWithRemoveSideEffect() {
        detailsViewModel.onEvent(DetailsEvent.RemoveSideEffect)

        assertNull(detailsViewModel.sideEffect)
    }

    @Test
    fun testOnEventWithDeleteArticle() {
        //Arrange
        val newsDao = Mockito.mock(NewsDao::class.java)
        val article = Mockito.mock(Article::class.java)
        val selectArticleUseCase = SelectArticleUseCase(newsDao)
        val deleteArticleUseCase = DeleteArticleUseCase(newsDao)
        val event = DetailsEvent.UpsertDeleteArticle(article)

        Mockito.`when`(article.url).thenReturn("url")
        Mockito.`when`(newsUseCases.selectArticleUseCase).thenReturn(selectArticleUseCase)
        Mockito.`when`(newsUseCases.deleteArticleUseCase).thenReturn(deleteArticleUseCase)

        runTest {
            Mockito.`when`(newsDao.getArticle(anyString())).thenReturn(article)

            //Act
            detailsViewModel.onEvent(event)
        }

        //Assert
        assertNotNull(detailsViewModel.sideEffect)
    }

    @Test
    fun testOnEventWithUpsertArticle() {
        //Arrange
        val newsDao = Mockito.mock(NewsDao::class.java)
        val article = Mockito.mock(Article::class.java)
        val selectArticleUseCase = SelectArticleUseCase(newsDao)
        val upsertArticleUseCase = UpsertArticleUseCase(newsDao)
        val event = DetailsEvent.UpsertDeleteArticle(article)

        Mockito.`when`(article.url).thenReturn(null)
        Mockito.`when`(newsUseCases.selectArticleUseCase).thenReturn(selectArticleUseCase)
        Mockito.`when`(newsUseCases.upsertArticleUseCase).thenReturn(upsertArticleUseCase)

        runTest {
            //Act
            detailsViewModel.onEvent(event)
        }

        //Assert
        assertNotNull(detailsViewModel.sideEffect)
    }

}