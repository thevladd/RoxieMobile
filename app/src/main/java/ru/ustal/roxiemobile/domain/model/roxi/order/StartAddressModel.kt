package ru.ustal.roxiemobile.domain.model.roxi.order

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class StartAddressModel(
    val address: String,
    val city: String
) : Parcelable