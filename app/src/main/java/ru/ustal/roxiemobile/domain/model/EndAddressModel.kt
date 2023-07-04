package ru.ustal.roxiemobile.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EndAddressModel(
    val address: String,
    val city: String
) : Parcelable