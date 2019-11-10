package com.chetan.base.ui.binding

import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView

/**
 * Allows DataBinding to set items into [RecyclerView.Adapter]. Refer [RecyclerView.setItems].
 */
interface BindableAdapter<T> {
     var items: PagedList<T>
}
