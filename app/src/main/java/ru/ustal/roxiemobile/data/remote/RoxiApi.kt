package ru.ustal.roxiemobile.data.remote

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import ru.ustal.roxiemobile.domain.model.roxi.order.OrderModel

interface RoxiApi {
    @GET("careers/test/orders.json")
    fun getOrders(): Single<List<OrderModel>>

    @GET("careers/test/images/{url}")
    fun getImage(
        @Path("url") url: String
    ): Single<ResponseBody>

}