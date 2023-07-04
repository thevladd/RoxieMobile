package ru.ustal.roxiemobile.domain.mapper

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import ru.ustal.roxiemobile.domain.model.OrderModel
import ru.ustal.roxiemobile.domain.model.view.OrderModelView
import ru.ustal.roxiemobile.utils.DateUtils

class OrderMapper : BaseMapper<OrderModel, OrderModelView>() {
    override fun map(input: OrderModel): OrderModelView {
        val date = LocalDateTime.parse(
            input.orderTime,
            DateTimeFormatter.ofPattern(DateUtils.serverDateFormat)
        )

        val formatter = DateTimeFormatter.ofPattern(DateUtils.viewDateFormat)

        val formattedDate = date.format(formatter)
        val startAddress = "${input.startAddress.city}, ${input.startAddress.address}"
        val endAddress = "${input.endAddress.city}, ${input.endAddress.address}"

        return OrderModelView(
            id = input.id,
            startAddress = startAddress,
            endAddress = endAddress,
            orderTime = formattedDate,
            price = input.price.formatPrice(),
            vehicle = input.vehicle
        )
    }
}