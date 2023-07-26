package ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView


interface IDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Any>, position: Int)

    fun onRecycled(holder: RecyclerView.ViewHolder)

    fun isForViewType(items: List<Any>, position: Int): Boolean

    fun itemId(item: Any): Any

    fun itemContent(item: Any): Any

    fun onAttachedToWindow(holder: RecyclerView.ViewHolder, content: Any)

    fun onDetachedFromWindow(holder: RecyclerView.ViewHolder)
}