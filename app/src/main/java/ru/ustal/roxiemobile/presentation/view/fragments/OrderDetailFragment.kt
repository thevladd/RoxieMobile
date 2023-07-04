package ru.ustal.roxiemobile.presentation.view.fragments

import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.ustal.roxiemobile.databinding.FragmentOrderDetailBinding
import ru.ustal.roxiemobile.domain.model.view.OrderModelView
import ru.ustal.roxiemobile.presentation.viewModel.OrderDetailViewModel
import ru.ustal.roxiemobile.utils.OperationResult
import java.io.File
import java.io.FileOutputStream

class OrderDetailFragment : Fragment() {

    private lateinit var binding: FragmentOrderDetailBinding
    private val viewModel: OrderDetailViewModel by viewModels()
    private var order: OrderModelView? = null
    private var cacheDirectory: File? = null
    private var cacheFile: File? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOrderDetailBinding.inflate(inflater)
        setArguments()
        binding.lifecycleOwner = this
        binding.order = order

        cacheDirectory = requireContext().cacheDir
        cacheFile = File(cacheDirectory, "${order?.vehicle?.photo}")
        checkImageCache()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.image.observe(viewLifecycleOwner) { image ->
            if (image is OperationResult.OperationError) {
                Toast.makeText(requireContext(), image.errorMessage, Toast.LENGTH_LONG).show()
            }
            if (image is OperationResult.Success) {
                setImage(image.data.bytes)
            }

        }
    }

    private fun checkImageCache() {
        if (cacheFile?.exists() == true && System.currentTimeMillis() - (cacheFile?.lastModified()
                ?: 0) < 10 * 60 * 1000
        ) {
            val bitmap = BitmapFactory.decodeFile(cacheFile!!.absolutePath)
            binding.imageView.setImageBitmap(bitmap)
        } else {
            viewModel.getImage(order?.vehicle?.photo ?: "")
        }
    }

    private fun setImage(byteArray: ByteArray) {
        val outputStream = FileOutputStream(cacheFile)
        outputStream.write(byteArray)
        outputStream.close()

        val bitmap =
            BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        binding.imageView.setImageBitmap(bitmap)
    }

    private fun setArguments() {
        if (arguments != null && requireArguments().containsKey("order"))
            order = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requireArguments().getSerializable("order", OrderModelView::class.java)
            } else
                requireArguments().getSerializable("order") as OrderModelView
    }

}