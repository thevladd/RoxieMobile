package ru.ustal.roxiemobile.domain.model

abstract class PaginatedResponse(
    val next_page: String? = "",
    val page: Int? = 0,
    val per_page: Int? = 0,
    val prev_page: String? = "",
    val total_results: Int? = 0,
    val url: String? = null
)