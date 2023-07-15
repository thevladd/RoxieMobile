package ru.ustal.roxiemobile.domain.repository

import io.reactivex.Single
import ru.ustal.roxiemobile.domain.model.PaginatedRequestParams
import ru.ustal.roxiemobile.domain.model.pixels.photo.PhotosModel

interface PhotoRepository {

    fun getPhotos(path: String, params: PaginatedRequestParams?): Single<PhotosModel>

}