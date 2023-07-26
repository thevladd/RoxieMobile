package ru.ustal.roxiemobile.utils

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter.CompositeDelegateAdapter

@BindingAdapter("errorText")
fun setErrorText(view: TextView, dataObject: Any?) {
    view.isVisible = dataObject is OperationResult.OperationError
    view.text = if (dataObject is OperationResult.OperationError) dataObject.errorMessage else ""

}

@BindingAdapter("recyclerItems")
@Suppress("UNCHECKED_CAST")
fun setRecyclerItems(recyclerView: RecyclerView, data: Any?) {
    recyclerView.isVisible = data !is OperationResult.OperationError
    ((data as? OperationResult.Success<*>)?.data as? List<Any>)?.let {
        (recyclerView.adapter as? CompositeDelegateAdapter)?.swapData(
            it
        )
    }
}