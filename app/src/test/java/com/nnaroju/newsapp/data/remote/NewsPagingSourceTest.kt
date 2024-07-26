package com.nnaroju.newsapp.data.remote

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nnaroju.newsapp.data.remote.dto.NewsResponse
import com.nnaroju.newsapp.domain.model.Article
import com.nnaroju.newsapp.domain.model.Source
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class NewsPagingSourceTest {

    @Mock
    private lateinit var newsApi: NewsApi

    private lateinit var newsPagingSource: NewsPagingSource

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        newsPagingSource = NewsPagingSource(newsApi, "test_sources")
    }

    @Test
    fun load_returnsPage_whenOnSuccessfulResponse() = runTest {
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
        val newsResponse = NewsResponse(totalResults = 2, status = "Success", articles = articles)
        Mockito.`when`(newsApi.getNews(anyInt(), anyString(), anyString())).thenReturn(newsResponse)

        val result = newsPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 2,
                placeholdersEnabled = false
            )
        )

        assert(result is PagingSource.LoadResult.Page)
        val page = result as PagingSource.LoadResult.Page
        assert(page.data == articles)
        assert(page.nextKey == 2)
        assert(page.prevKey == null)
    }


    @Test
    fun load_returnsError_whenOnErrorResponse() = runTest {
        val exception = RuntimeException("Network error")
        Mockito.`when`(newsApi.getNews(anyInt(), anyString(), anyString())).thenThrow(exception)

        // When
        val result = newsPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 2,
                placeholdersEnabled = false
            )
        )

        // Then
        assert(result is PagingSource.LoadResult.Error)
        val error = result as PagingSource.LoadResult.Error
        assert(error.throwable == exception)
    }

    @Test
    fun getRefreshKey() {
        // Given
        val state = PagingState<Int, Article>(
            pages = listOf(),
            anchorPosition = null,
            config = PagingConfig(pageSize = 2),
            leadingPlaceholderCount = 0
        )

        // When
        val key = newsPagingSource.getRefreshKey(state)

        // Then
        assert(key == null)
    }

}
