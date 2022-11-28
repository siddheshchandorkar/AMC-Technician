package com.amc.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class BindingUtils {

    companion object{
        const val ROW_DATA = "setRowData"
        @JvmStatic
        @BindingAdapter(ROW_DATA)
        fun setRowLayoutData(recyclerView: RecyclerView, listData: List<BaseRowModel>) {
            if (listData == null) return
            var adapter = recyclerView.adapter
            if (adapter == null || listData.isEmpty()) {
                adapter = RecyclerViewBindingAdapter(listData)
                adapter.setHasStableIds(true)
                recyclerView.adapter = adapter
            } else {
                adapter.notifyDataSetChanged()
            }
        }
    }
}