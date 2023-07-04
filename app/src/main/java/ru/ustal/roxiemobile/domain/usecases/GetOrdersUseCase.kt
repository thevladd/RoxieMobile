package ru.ustal.roxiemobile.domain.usecases

import io.reactivex.Single
import ru.ustal.roxiemobile.domain.model.OrderModel
import ru.ustal.roxiemobile.domain.repository.OrderRepository

class GetOrdersUseCase(private val ordersRepository: OrderRepository) {

    fun execute(): Single<List<OrderModel>> {
        return ordersRepository.getOrders()
    }
}