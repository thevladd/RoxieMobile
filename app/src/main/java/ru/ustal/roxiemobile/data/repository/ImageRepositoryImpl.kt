package ru.ustal.roxiemobile.data.repository

import io.reactivex.Single
import ru.ustal.roxiemobile.data.remote.RoxiApi
import ru.ustal.roxiemobile.domain.model.BitmapModel
import ru.ustal.roxiemobile.domain.repository.ImageRepository

class ImageRepositoryImpl(private val roxiApi: RoxiApi) : ImageRepository {
    override fun getImage(imageUrl: String): Single<BitmapModel> {
        return roxiApi.getImage(imageUrl).map { BitmapModel(bytes = it.bytes()) }
    }
}