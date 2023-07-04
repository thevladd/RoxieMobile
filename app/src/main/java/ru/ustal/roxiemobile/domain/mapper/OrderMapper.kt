package ru.ustal.roxiemobile.domain.mapper

//class OrderMapper : BaseMapper<OrderModel, OrderItem>() {
//    override fun map(input: OrderModel): OrderItem {
//        val startAddress = "${input.startAddress.city}, ${input.startAddress.address}"
//        val endAddress = "${input.endAddressModel.city}, ${input.endAddressModel.address}"
//        val orderDate = input.orderTime.substring(0, 10)
//        val orderPrice = "${input.price.amount} ${input.price.currency}"
//
//        return OrderItem(
//            id = input.id,
//            startAddress = startAddress,
//            endAddress = endAddress,
//            orderDate = orderDate,
//            orderPrice = orderPrice
//        )
//    }
//}