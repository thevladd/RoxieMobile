package ru.ustal.roxiemobile.domain.repository

import io.reactivex.Single
import ru.ustal.roxiemobile.domain.model.BitmapModel

interface ImageRepository {

    fun getImage(imageUrl: String): Single<BitmapModel>

}