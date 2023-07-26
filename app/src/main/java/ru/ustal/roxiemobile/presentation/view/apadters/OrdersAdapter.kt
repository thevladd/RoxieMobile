package ru.ustal.roxiemobile.presentation.view.apadters

import ru.ustal.roxiemobile.databinding.ItemOrderBinding
import ru.ustal.roxiemobile.domain.model.view.OrderModelView
import ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter.KDelegateAdapter

class OrdersAdapter :
    KDelegateAdapter<OrderModelView, ItemOrderBinding>(ItemOrderBinding::inflate) {

    override fun ItemOrderBinding.onBind(item: OrderModelView) {
        order = item
    }

    override fun isForViewType(item: Any): Boolean = item is OrderModelView

    override fun OrderModelView.getItemId(): Any = this.hashCode()
}