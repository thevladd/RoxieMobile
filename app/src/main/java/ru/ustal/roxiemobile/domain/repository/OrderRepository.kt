package ru.ustal.roxiemobile.domain.repository

import io.reactivex.Single
import ru.ustal.roxiemobile.domain.model.roxi.order.OrderModel

interface OrderRepository {

    fun getOrders(): Single<List<OrderModel>>

}