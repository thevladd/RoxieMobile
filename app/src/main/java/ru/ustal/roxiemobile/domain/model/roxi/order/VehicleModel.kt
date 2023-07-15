package ru.ustal.roxiemobile.domain.model.roxi.order

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class VehicleModel(
    val driverName: String,
    val modelName: String,
    val photo: String,
    val regNumber: String
) : Parcelable