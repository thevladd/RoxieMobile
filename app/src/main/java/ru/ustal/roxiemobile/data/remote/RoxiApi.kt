package ru.ustal.roxiemobile.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import ru.ustal.roxiemobile.domain.model.roxi.order.OrderModel

interface RoxiApi {
    @GET("careers/test/orders.json")
    fun getOrders(): Single<List<OrderModel>>

}