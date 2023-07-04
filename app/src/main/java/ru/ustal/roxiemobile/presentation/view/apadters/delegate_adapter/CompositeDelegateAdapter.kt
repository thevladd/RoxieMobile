package ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter

import android.annotation.SuppressLint
import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class CompositeDelegateAdapter(
    private val typeToAdapterMap: SparseArray<IDelegateAdapter<out RecyclerView.ViewHolder>>,
    private val onItemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val FIRST_VIEW_TYPE = 0
    }

    private var data: List<Any> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        for (i in FIRST_VIEW_TYPE until typeToAdapterMap.size()) {
            val delegate = typeToAdapterMap.valueAt(i)
            if (delegate.isForViewType(data, position)) {
                return typeToAdapterMap.keyAt(i)
            }
        }
        throw NullPointerException("Can not get viewType for position $position")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return typeToAdapterMap.get(viewType)?.onCreateViewHolder(parent, viewType)
            ?: throw NullPointerException("Can not find adapter for viewType $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val delegate = typeToAdapterMap.get(getItemViewType(position))
            ?: throw NullPointerException("Can not find adapter for position $position")
        delegate.onBindViewHolder(holder, data, position)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        typeToAdapterMap.get(holder.itemViewType)?.onRecycled(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        holder.itemView.setOnClickListener { onItemClick.invoke(holder.adapterPosition) }
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun swapData(data: List<Any>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    class Builder {
        private var onItemClick: (Int) -> Unit = {}
        private var count: Int = 0
        private val typeToAdapterMap: SparseArray<IDelegateAdapter<out RecyclerView.ViewHolder>> =
            SparseArray()

        fun add(delegateAdapter: IDelegateAdapter<out RecyclerView.ViewHolder>): Builder {
            typeToAdapterMap.put(count++, delegateAdapter)
            return this
        }

        fun addItemClickListener(onItemClick: (Int) -> Unit): Builder {
            this.onItemClick = onItemClick
            return this
        }

        fun build(): CompositeDelegateAdapter {
            if (count == 0) {
                throw IllegalArgumentException("Register at least one adapter")
            }
            return CompositeDelegateAdapter(typeToAdapterMap, onItemClick)
        }
    }
}