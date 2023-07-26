package ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.ustal.roxiemobile.utils.sparseArrayToList


open class CompositeDelegateAdapter(
    adapters: SparseArray<IDelegateAdapter>,
    private val onItemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected open var adapterState = AdaptersState(adapters.sparseArrayToList())

    override fun getItemViewType(itemPosition: Int): Int =
        adapterState.getAdapterPosition(itemPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        adapterState.getAdapter(viewType).onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        adapterState.getAdapter(getItemViewType(position))
            .onBindViewHolder(holder, adapterState.data, position)

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) =
        adapterState.getAdapter(holder.itemViewType).onRecycled(holder)

    open fun swapData(data: List<Any>) {
        val newAdapterState = adapterState.copy(data = data)
        val diffCallback = DiffUtilCallback(adapterState, newAdapterState)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        adapterState = newAdapterState
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        holder.itemView.setOnClickListener { onItemClick.invoke(holder.absoluteAdapterPosition) }
        adapterState.getAdapter(holder.itemViewType).onAttachedToWindow(
            holder,
            adapterState.itemContent(holder.absoluteAdapterPosition)
        )
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        holder.itemView.setOnClickListener(null)

        adapterState.getAdapter(holder.itemViewType).onDetachedFromWindow(
            holder
        )
    }

    override fun getItemCount(): Int = adapterState.data.size


    class Builder {
        private var onItemClick: (Int) -> Unit = {}
        private var count: Int = 0
        private val typeToAdapterMap: SparseArray<IDelegateAdapter> = SparseArray()

        fun add(delegateAdapter: IDelegateAdapter): Builder {
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