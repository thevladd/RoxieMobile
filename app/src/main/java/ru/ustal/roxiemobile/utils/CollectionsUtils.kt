package ru.ustal.roxiemobile.utils

import android.util.SparseArray

fun <T> SparseArray<T>.sparseArrayToList(): List<T> {
    val list = mutableListOf<T>()
    for (i in 0 until size()) {
        val value = valueAt(i)
        list.add(value)
    }
    return list
}