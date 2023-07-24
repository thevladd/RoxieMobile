package ru.ustal.roxiemobile.domain.model.view

import ru.ustal.roxiemobile.domain.model.roxi.order.VehicleModel
import java.io.Serializable

data class OrderModelView(
    val endAddress: String,
    val id: Int,
    val orderTime: String,
    val price: String,
    val startAddress: String,
    val vehicle: VehicleModel
) : Serializable
