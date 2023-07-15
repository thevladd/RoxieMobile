package ru.ustal.roxiemobile.domain.model

import retrofit2.http.Query

data class PaginatedRequestParams(
    @Query("page") val page: Int? = null,
    @Query("per_page") val per_page: Int? = null,
    @Query("query") val query: String? = null
)