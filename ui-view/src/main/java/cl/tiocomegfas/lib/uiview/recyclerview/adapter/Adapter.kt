package cl.tiocomegfas.lib.uiview.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

interface Adapter<VB: ViewBinding, Item: AdapterItem> {
    fun onCreateBinding(inflater: LayoutInflater, parent: ViewGroup): VB
    fun onDrawItem(binding: VB, item: Item, position: Int)
    fun insertItem(item: Item)
    fun updateItem(item: Item)
    fun upsertItem(item: Item)
    fun removeItem(item: Item)
    fun removeAll()
    fun getItems(): List<Item>
    fun contains(item: Item): Boolean
    fun isSameObject(oldItem: Item, newItem: Item): Boolean
}