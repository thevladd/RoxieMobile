package ru.ustal.roxiemobile.domain.model.roxi.order

import java.io.Serializable

data class AddressModel(
    val address: String,
    val city: String
) : Serializable