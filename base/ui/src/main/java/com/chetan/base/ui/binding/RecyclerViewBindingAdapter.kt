package com.chetan.base.ui.binding

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Set items into [BindableAdapter], throws [IllegalStateException] if [RecyclerView.Adapter] does not implements
 * [BindableAdapter].
 */
//@BindingAdapter("items")
//fun <M,V:RecyclerView.ViewHolder> RecyclerView.setItems(items: PagedList<M>?) {
//    val tempAdapter = (adapter as PagedListAdapter<M,V>)
//    if (tempAdapter is BindableAdapter<*>) {
//        @Suppress("UNCHECKED_CAST")
//        if(items!=null) {
//            tempAdapter.items = items
//        }
//    } else {
//        throw IllegalStateException("Your adapter should implement BindableAdapter")
//    }
//}
