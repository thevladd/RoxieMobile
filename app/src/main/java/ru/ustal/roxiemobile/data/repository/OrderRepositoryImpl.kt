package ru.ustal.roxiemobile.data.repository

import io.reactivex.Single
import ru.ustal.roxiemobile.data.remote.RoxiApi
import ru.ustal.roxiemobile.domain.model.roxi.order.OrderModel
import ru.ustal.roxiemobile.domain.repository.OrderRepository

class OrderRepositoryImpl(private val roxiApi: RoxiApi) : OrderRepository {
    override fun getOrders(): Single<List<OrderModel>> {
        return roxiApi.getOrders()
    }
}