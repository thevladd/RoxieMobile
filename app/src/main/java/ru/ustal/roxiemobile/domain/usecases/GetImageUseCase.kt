package ru.ustal.roxiemobile.domain.usecases

import io.reactivex.Single
import ru.ustal.roxiemobile.domain.model.BitmapModel
import ru.ustal.roxiemobile.domain.repository.ImageRepository

class GetImageUseCase(private val imageRepository: ImageRepository) {

    fun execute(url: String): Single<BitmapModel> {
        return imageRepository.getImage(url)
    }
}