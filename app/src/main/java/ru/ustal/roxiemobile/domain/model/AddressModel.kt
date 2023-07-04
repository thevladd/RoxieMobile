package ru.ustal.roxiemobile.domain.model

import java.io.Serializable

data class AddressModel(
    val address: String,
    val city: String
) : Serializable