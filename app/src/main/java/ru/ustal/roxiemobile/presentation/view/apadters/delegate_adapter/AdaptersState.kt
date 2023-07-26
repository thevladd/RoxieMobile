package ru.ustal.roxiemobile.presentation.view.apadters.delegate_adapter

data class AdaptersState(
    private val adapters: List<IDelegateAdapter>,
    val data: List<Any> = emptyList()
) {

    private val adapterPositionsCache = Array(data.size) { -1 }

    fun getAdapterPosition(itemPosition: Int): Int =
        adapterPositionsCache[itemPosition].takeIf { it != -1 }
            ?: adapters.indexOfFirst { it.isForViewType(data, itemPosition) }
                .takeIf { it != -1 }
                ?.also { adapterPositionsCache[itemPosition] = it }
            ?: error("Provide adapter for type ${data[itemPosition].javaClass} at position: $itemPosition")

    fun getAdapter(adapterPosition: Int): IDelegateAdapter = adapters[adapterPosition]

    private fun getAdapterByItemPosition(itemPosition: Int): IDelegateAdapter =
        adapters[getAdapterPosition(itemPosition)]


    fun itemId(position: Int): Any =
        getAdapterByItemPosition(position).itemId(data[position])

    fun itemContent(position: Int): Any =
        getAdapterByItemPosition(position).itemContent(data[position])
}