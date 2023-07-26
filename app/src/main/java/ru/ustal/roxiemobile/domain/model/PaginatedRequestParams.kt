package ru.ustal.roxiemobile.domain.model

data class PaginatedRequestParams(
    val page: Int? = null,
    val perPage: Int? = null,
    val query: String? = null
)