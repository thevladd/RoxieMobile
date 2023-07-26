package ru.ustal.roxiemobile.domain.model.pixels.video

import ru.ustal.roxiemobile.domain.model.PaginatedResponse

data class VideosModel(
    val videos: List<VideoModel>? = null
) : PaginatedResponse()