package ru.ustal.roxiemobile.data.repository

import io.reactivex.Single
import ru.ustal.roxiemobile.data.remote.PixelsApi
import ru.ustal.roxiemobile.domain.model.PaginatedRequestParams
import ru.ustal.roxiemobile.domain.model.pixels.photo.PhotosModel
import ru.ustal.roxiemobile.domain.repository.PhotoRepository

class PhotoRepositoryImpl(private val pixelsApi: PixelsApi) : PhotoRepository {

    override fun getPhotos(path: String, params: PaginatedRequestParams?): Single<PhotosModel> {
        return pixelsApi.getPhotos(path = path, params = params)
    }

}