package ru.ustal.roxiemobile.presentation.view.apadters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.ustal.roxiemobile.R
import ru.ustal.roxiemobile.databinding.ItemOrderBinding
import ru.ustal.roxiemobile.domain.model.roxi.order.OrderModel
import ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter.BaseDelegateAdapter
import ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter.BaseViewHolder

class OrdersAdapter :
    BaseDelegateAdapter<OrdersAdapter.OrderViewHolder, OrderModel>() {

    override fun onBindViewHolder(
        view: View,
        item: OrderModel,
        viewHolder: OrderViewHolder
    ) {
        viewHolder.binding.order = item
    }

    override fun getLayoutId(): Int {
        return R.layout.item_order
    }

    override fun createViewHolder(parent: ViewGroup): OrderViewHolder {
        return OrderViewHolder.from(parent)
    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is OrderModel
    }

    class OrderViewHolder(
        val binding: ItemOrderBinding
    ) : BaseViewHolder(binding.root) {
        companion object {
            fun from(
                parent: ViewGroup
            ): OrderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ItemOrderBinding.inflate(layoutInflater, parent, false)
                return OrderViewHolder(binding)
            }
        }
    }
}