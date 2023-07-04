package ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView


interface IDelegateAdapter<VH : RecyclerView.ViewHolder> {

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Any>, position: Int)

    fun onRecycled(holder: RecyclerView.ViewHolder)

    fun isForViewType(items: List<Any>, position: Int): Boolean
}