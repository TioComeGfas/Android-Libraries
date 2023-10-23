package cl.tiocomegfas.lib.uiview.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<VB: ViewBinding, Item: AdapterItem>(
    var items: List<Item> = listOf()
): RecyclerView.Adapter<BaseAdapter<VB, Item>.BaseHolder>(), Adapter<VB, Item> {
    private val diffUtil: BaseDiffUtil by lazy { BaseDiffUtil() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return BaseHolder(
            onCreateBinding(LayoutInflater.from(parent.context), parent)
        )
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        if (position == RecyclerView.NO_POSITION) return
        if(items.isEmpty()) return
        if(position >= items.size) return
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun insertItem(item: Item) {
        items = items.plus(item)
        diffUtil.updateItems(items)
    }

    override fun upsertItem(item: Item) {
        if(contains(item)) updateItem(item)
        else insertItem(item)
        diffUtil.updateItems(items)
    }

    override fun updateItem(item: Item) {
        items = items.minus(item).plus(item)
        diffUtil.updateItems(items)
    }

    override fun removeItem(item: Item) {
        items = items.minus(item)
        diffUtil.updateItems(items)
    }

    override fun removeAll() {
        items = listOf()
        diffUtil.updateItems(items)
    }

    override fun contains(item: Item): Boolean {
        return items.contains(item)
    }

    override fun getItems(): List<Item> {
        return items
    }

    inner class BaseHolder(
        private val binding: VB
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item, position: Int) {
            onDrawItem(binding, item, position)
        }
    }

    open inner class BaseDiffUtil: DiffUtil.Callback() {
        private var newList: List<Item> = emptyList()

        fun updateItems(newItems: List<Item>) {
            newList = newItems
        }

        override fun getOldListSize(): Int {
            return items.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return isSameObject(items[oldItemPosition], newList[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return items[oldItemPosition] == newList[newItemPosition]
        }

    }
}