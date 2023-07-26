package ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class KDelegateAdapter<T : Any, V : ViewBinding>(
    val viewBindingInflater: (LayoutInflater, parent: ViewGroup, attachToParent: Boolean) -> V
) : IDelegateAdapter {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = viewBindingInflater.invoke(layoutInflater, parent, false)
        viewBinding.onCreated()
        return ViewBindingHolder(
            viewBinding
        )
    }

    open fun V.onCreated() {}

    @Suppress("UNCHECKED_CAST")
    final override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        items: List<Any>,
        position: Int
    ) {
        holder as ViewBindingHolder<V>
        holder.viewBinding.onBind(items[position] as T)
    }

    abstract fun V.onBind(item: T)

    @Suppress("UNCHECKED_CAST")
    override fun onRecycled(holder: RecyclerView.ViewHolder) {
        (holder as ViewBindingHolder<V>).viewBinding.onRecycled()
    }

    open fun V.onRecycled() {}

    abstract fun isForViewType(item: Any): Boolean

    abstract fun T.getItemId(): Any

    override fun itemContent(item: Any): Any = item

    @Suppress("UNCHECKED_CAST")
    final override fun itemId(item: Any): Any = (item as T).getItemId()

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return isForViewType(items[position])
    }

    @Suppress("UNCHECKED_CAST")
    final override fun onAttachedToWindow(holder: RecyclerView.ViewHolder, content: Any) =
        (holder as ViewBindingHolder<V>).let {
            it.viewBinding.onAttachedToWindow(it, content as T)
        }

    @Suppress("UNCHECKED_CAST")
    final override fun onDetachedFromWindow(holder: RecyclerView.ViewHolder) =
        (holder as ViewBindingHolder<V>).let {
            it.viewBinding.onDetachedFromWindow(it)
        }

    open fun V.onAttachedToWindow(holder: ViewBindingHolder<V>, content: T) {}
    open fun V.onDetachedFromWindow(holder: ViewBindingHolder<V>) {}

    open class ViewBindingHolder<V : ViewBinding>(
        val viewBinding: V
    ) : RecyclerView.ViewHolder(viewBinding.root)
}