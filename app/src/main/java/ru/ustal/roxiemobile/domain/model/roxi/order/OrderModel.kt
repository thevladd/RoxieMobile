package ru.ustal.roxiemobile.domain.model.roxi.order

import java.io.Serializable

data class OrderModel(
    val endAddress: AddressModel,
    val id: Int,
    val orderTime: String,
    val price: PriceModel,
    val startAddress: AddressModel,
    val vehicle: VehicleModel
) : Serializable






