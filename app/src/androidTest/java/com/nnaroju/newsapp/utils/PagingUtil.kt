package com.nnaroju.newsapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun <T : Any> rememberLazyPagingItems(items: List<T>, shouldThrowError: Boolean): LazyPagingItems<T> {
    val pagingData = remember {
        Pager(PagingConfig(pageSize = 20)) {
            FakePagingSource(items,shouldThrowError)
        }.flow
    }
    return pagingData.collectAsLazyPagingItems()
}

class FakePagingSource<T : Any>(
    private val items: List<T>,
    private val shouldThrowError: Boolean = false
) : PagingSource<Int, T>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return if (shouldThrowError) {
            LoadResult.Error(Exception("Exception occurred"))
        } else {
            val page = params.key ?: 0
            val start = page * params.loadSize
            val end = minOf(start + params.loadSize, items.size)
            LoadResult.Page(
                data = items.subList(start, end),
                prevKey = if (page > 0) page - 1 else null,
                nextKey = if (end < items.size) page + 1 else null
            )
        }

    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

