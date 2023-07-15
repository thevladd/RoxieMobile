package ru.ustal.roxiemobile.domain.model.roxi.order

import android.icu.util.Currency
import java.io.Serializable
import kotlin.math.pow

data class PriceModel(
    val amount: Int,
    val currency: String
) : Serializable {
    fun formatPrice(): String {

        val currency: Currency = Currency.getInstance(currency)
        val decimalPlaces: Int = currency.defaultFractionDigits
        val amountInCurrency = amount / 10.0.pow(decimalPlaces.toDouble())
        return "Сумма: $amountInCurrency ${currency.symbol}"
    }

}