package ru.ustal.roxiemobile.domain.repository

import io.reactivex.Single
import ru.ustal.roxiemobile.domain.model.PaginatedRequestParams
import ru.ustal.roxiemobile.domain.model.pixels.video.VideosModel

interface VideoRepository {

    fun getVideos(path: String, params: PaginatedRequestParams?): Single<VideosModel>

}