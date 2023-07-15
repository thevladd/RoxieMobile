package ru.ustal.roxiemobile.domain.usecases

import io.reactivex.Single
import ru.ustal.roxiemobile.domain.model.PaginatedRequestParams
import ru.ustal.roxiemobile.domain.model.pixels.photo.PhotosModel
import ru.ustal.roxiemobile.domain.repository.PhotoRepository

class GetPhotosUseCase(private val photoRepository: PhotoRepository) {

    //TODO Заменить возвращаемую модельку на модельку для вью
    fun execute(path: String, params: PaginatedRequestParams? = null): Single<PhotosModel> {
        return photoRepository.getPhotos(path = path, params = params)
    }
}