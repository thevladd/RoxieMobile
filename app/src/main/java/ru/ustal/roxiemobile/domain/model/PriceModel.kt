package ru.ustal.roxiemobile.domain.model

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class PriceModel(
    val amount: Int,
    val currency: String
) : Parcelable