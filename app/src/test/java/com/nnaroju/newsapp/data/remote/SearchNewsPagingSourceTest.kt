package com.nnaroju.newsapp.data.remote

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nnaroju.newsapp.data.remote.dto.NewsResponse
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class SearchNewsPagingSourceTest {

    private lateinit var newsApi: NewsApi
    private lateinit var pagingSource: SearchNewsPagingSource

    @Before
    fun setUp() {
        newsApi = mock(NewsApi::class.java)
        pagingSource = SearchNewsPagingSource(newsApi, "query", "sources")
    }

    @Test
    fun `load returns page when on successful load`() = runTest {
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

        val response = NewsResponse(articles = articles, status = "success", totalResults = 100)
        `when`(newsApi.searchNews("query", 1, "sources")).thenReturn(response)

        val result = pagingSource.load(PagingSource.LoadParams.Refresh(1, 2, false))

        assertTrue(result is PagingSource.LoadResult.Page)
        val pageResult = result as PagingSource.LoadResult.Page
        assertEquals(articles, pageResult.data)
        assertEquals(null, pageResult.prevKey)
        assertEquals(2, pageResult.nextKey)
    }

    @Test
    fun `load returns error when api call fails`() = runTest {
        val exception = RuntimeException("Network error")
        `when`(newsApi.searchNews(anyString(), anyInt(), anyString(), anyString())).thenThrow(
            exception
        )

        val result = pagingSource.load(PagingSource.LoadParams.Refresh(null, 2, false))

        assertTrue(result is PagingSource.LoadResult.Error)
        val errorResult = result as PagingSource.LoadResult.Error
        assertEquals(exception, errorResult.throwable)
    }

    @Test
    fun `getRefreshKey returns correct key`() {
        val state = PagingState(
            pages = listOf(
                PagingSource.LoadResult.Page(
                    data = listOf(
                        Article(
                            "Author",
                            "content",
                            "description",
                            "2024-07-01T15:17:57Z",
                            Source(id = "1", "name"),
                            "title", "url", "imageurl"
                        )
                    ),
                    prevKey = null,
                    nextKey = 2
                )
            ),
            anchorPosition = 1,
            config = PagingConfig(pageSize = 1),
            leadingPlaceholderCount = 0
        )

        val key = pagingSource.getRefreshKey(state)
        assertEquals(1, key)
    }
}
