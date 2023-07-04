package ru.ustal.roxiemobile.presentation.view.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.ustal.roxiemobile.databinding.FragmentOrderDetailBinding
import ru.ustal.roxiemobile.domain.model.OrderModel
import ru.ustal.roxiemobile.presentation.viewModel.OrderDetailViewModel

class OrderDetailFragment : Fragment() {

    private lateinit var binding: FragmentOrderDetailBinding
    private val viewModel: OrderDetailViewModel by viewModels()
    private var order: OrderModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOrderDetailBinding.inflate(inflater)
        if (arguments != null && requireArguments().containsKey("order"))
            order = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requireArguments().getParcelable("order", OrderModel::class.java)
            } else requireArguments().getParcelable("order")

        return binding.root
    }

}