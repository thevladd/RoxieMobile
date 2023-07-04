package ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter.BaseViewHolder.ItemInflateListener


abstract class BaseDelegateAdapter<VH : BaseViewHolder, T> : IDelegateAdapter<VH> {

    protected abstract fun onBindViewHolder(
        view: View,
        item: T,
        viewHolder: VH
    )

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun createViewHolder(parent: ViewGroup): VH

    override fun onRecycled(holder: RecyclerView.ViewHolder) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
//        val inflatedView = LayoutInflater.from(parent.context)
//            .inflate(getLayoutId(), parent, false)
        val holder = createViewHolder(parent)
        holder.setListener(object : ItemInflateListener {
            override fun inflated(viewType: Any, view: View) {
                onBindViewHolder(view, viewType as T, holder)
            }
        })
        return holder
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        items: List<Any>,
        position: Int
    ) {
        (holder as BaseViewHolder).bind(items[position])
    }
}