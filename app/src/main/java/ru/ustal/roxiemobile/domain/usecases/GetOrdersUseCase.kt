package ru.ustal.roxiemobile.domain.usecases

import io.reactivex.Single
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import ru.ustal.roxiemobile.domain.mapper.OrderMapper
import ru.ustal.roxiemobile.domain.model.view.OrderModelView
import ru.ustal.roxiemobile.domain.repository.OrderRepository
import ru.ustal.roxiemobile.utils.DateUtils

class GetOrdersUseCase(private val ordersRepository: OrderRepository) {

    fun execute(): Single<List<OrderModelView>> {
        return ordersRepository.getOrders()
            .map { orders ->
                OrderMapper().mapList(orders).sortedByDescending {
                    LocalDateTime.parse(
                        it.orderTime,
                        DateTimeFormatter.ofPattern(DateUtils.viewDateFormat)
                    )
                }
            }
    }
}