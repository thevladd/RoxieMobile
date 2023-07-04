package ru.ustal.roxiemobile.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.ustal.roxiemobile.R
import ru.ustal.roxiemobile.databinding.FragmentOrdersBinding
import ru.ustal.roxiemobile.presentation.view.apadters.OrdersAdapter
import ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter.CompositeDelegateAdapter
import ru.ustal.roxiemobile.presentation.viewModel.OrdersViewModel

class OrdersFragment : Fragment() {

    private lateinit var binding: FragmentOrdersBinding
    private val viewModel: OrdersViewModel by viewModels()
    private val adapter = CompositeDelegateAdapter.Builder()
        .add(OrdersAdapter())
        .addItemClickListener { navigateToOrderDetails(it) }
        .build()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvOrders.adapter = adapter
        return binding.root
    }

    private fun navigateToOrderDetails(orderPosition: Int) {
        val order = viewModel.getOrderByPosition(orderPosition)
        order?.let {
            findNavController().navigate(
                R.id.action_navigation_orders_to_navigation_order_detail,
                bundleOf("order" to it)
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initData()
    }

}