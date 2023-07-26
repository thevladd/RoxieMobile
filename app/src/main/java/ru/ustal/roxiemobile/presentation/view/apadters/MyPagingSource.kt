package ru.ustal.roxiemobile.presentation.view.apadters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.ustal.roxiemobile.data.remote.PixelsApi
import ru.ustal.roxiemobile.domain.model.pixels.video.VideoModel

//TODO coming soon...
class MyPagingSource(private val yourApiService: PixelsApi) : PagingSource<Int, VideoModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoModel> {
        try {
            val nextPage = params.key ?: 1
            val response = yourApiService.getVideos(
                path = "popular",
                page = nextPage
            ).blockingGet()
            return if (response.videos != null) {

                LoadResult.Page(
                    data = response.videos,
                    prevKey = null,
                    nextKey = response.page?.plus(1)
                )
            } else {
                LoadResult.Error(Exception("Error loading data"))
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, VideoModel>): Int? {
        return null
    }
}