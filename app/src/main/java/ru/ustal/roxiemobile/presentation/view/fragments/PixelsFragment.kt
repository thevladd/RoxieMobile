package ru.ustal.roxiemobile.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.ustal.roxiemobile.databinding.FragmentPixelsBinding
import ru.ustal.roxiemobile.presentation.viewModel.PixelsViewModel

class PixelsFragment : Fragment() {

    private lateinit var binding: FragmentPixelsBinding
    private val viewModel: PixelsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPixelsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initData()
    }

}