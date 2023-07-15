package ru.ustal.roxiemobile.domain.model.pixels.photo

import ru.ustal.roxiemobile.domain.model.PaginatedResponse

data class PhotosModel(
    val photos: List<PhotoModel>? = listOf()
) : PaginatedResponse()