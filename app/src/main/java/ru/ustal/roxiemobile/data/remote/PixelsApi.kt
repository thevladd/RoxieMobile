package ru.ustal.roxiemobile.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.ustal.roxiemobile.domain.model.PaginatedRequestParams
import ru.ustal.roxiemobile.domain.model.pixels.photo.PhotosModel
import ru.ustal.roxiemobile.domain.model.pixels.video.VideosModel

interface PixelsApi {

    @GET("videos/{path}")
    fun getVideos(
        @Path("path") path: String,
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: Int? = null,
        @Query("query") query: String? = null
    ): Single<VideosModel>

    @GET("v1/{path}")
    fun getPhotos(
        @Path("path") path: String,
        params: PaginatedRequestParams?
    ): Single<PhotosModel>

}