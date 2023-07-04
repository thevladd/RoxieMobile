package ru.ustal.roxiemobile.utils

sealed class OperationResult<out T> {
    data class Success<out T>(val data: T) : OperationResult<T>()
    data class OperationError(val errorMessage: String) : OperationResult<Nothing>()
}