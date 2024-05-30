package com.nnaroju.newsapp.domain.usecases.news

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class NewsUseCasesTest {

    @Mock
    private lateinit var getNewsUseCase: GetNewsUseCase

    @Mock
    private lateinit var searchNewsUseCase: SearchNewsUseCase

    @Mock
    private lateinit var upsertArticleUseCase: UpsertArticleUseCase

    @Mock
    private lateinit var deleteArticleUseCase: DeleteArticleUseCase

    @Mock
    private lateinit var selectArticleUseCase: SelectArticleUseCase

    @Mock
    private lateinit var selectArticlesUseCase: SelectArticlesUseCase

    private lateinit var newsUseCases: NewsUseCases

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        newsUseCases = NewsUseCases(
            getNews = getNewsUseCase,
            searchNews = searchNewsUseCase,
            upsertArticleUseCase = upsertArticleUseCase,
            deleteArticleUseCase = deleteArticleUseCase,
            selectArticlesUseCase = selectArticlesUseCase,
            selectArticleUseCase = selectArticleUseCase
        )
    }

    @Test
    fun `test all useCases of newsUseCases`() {
        //Assert
        assertNotNull(newsUseCases.getNews)
        assertNotNull(newsUseCases.searchNews)
        assertNotNull(newsUseCases.upsertArticleUseCase)
        assertNotNull(newsUseCases.deleteArticleUseCase)
        assertNotNull(newsUseCases.selectArticleUseCase)
        assertNotNull(newsUseCases.selectArticlesUseCase)
    }
}