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
fun setRecyclerItems(recyclerView: RecyclerView, dataObject: Any?) {
    recyclerView.isVisible = dataObject !is OperationResult.OperationError
    if (dataObject is OperationResult.Success<*> && recyclerView.adapter is CompositeDelegateAdapter) {
        (recyclerView.adapter as CompositeDelegateAdapter).swapData(dataObject.data as List<Any>)
    }

}