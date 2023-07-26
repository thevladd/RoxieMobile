package ru.ustal.roxiemobile.data.repository

import io.reactivex.Single
import ru.ustal.roxiemobile.data.remote.PixelsApi
import ru.ustal.roxiemobile.domain.model.PaginatedRequestParams
import ru.ustal.roxiemobile.domain.model.pixels.video.VideosModel
import ru.ustal.roxiemobile.domain.repository.VideoRepository

class VideoRepositoryImpl(private val pixelsApi: PixelsApi) : VideoRepository {

    override fun getVideos(path: String, params: PaginatedRequestParams?): Single<VideosModel> {
        return pixelsApi.getVideos(
            path = path,
            page = params?.page,
            perPage = params?.perPage,
            query = params?.query
        )
    }

}