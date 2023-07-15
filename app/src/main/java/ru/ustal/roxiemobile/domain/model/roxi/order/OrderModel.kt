package ru.ustal.roxiemobile.domain.model.roxi.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderModel(
    val endAddress: EndAddressModel,
    val id: Int,
    val orderTime: String,
    val price: PriceModel,
    val startAddress: StartAddressModel,
    val vehicle: VehicleModel
) : Parcelable






