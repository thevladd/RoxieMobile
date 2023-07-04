package ru.ustal.roxiemobile.domain.model

import java.io.Serializable

data class VehicleModel(
    val driverName: String,
    val modelName: String,
    val photo: String,
    val regNumber: String
) : Serializable