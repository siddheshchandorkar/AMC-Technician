package com.amc.common

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.gcacace.signaturepad.views.SignaturePad

class BindingUtils {

    companion object {
        private const val ROW_DATA = "setRowData"
        private const val VISIBILITY = "android:visibility"
        private const val SIGNATURE_LISTENER = "onSignedListener"

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

        @JvmStatic
        @BindingAdapter(VISIBILITY)
        fun setVisibility(view: View, visibility: Boolean) {
            if (visibility) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }

        }

        @JvmStatic
        @BindingAdapter(SIGNATURE_LISTENER)
        fun setVisibility(view: SignaturePad, listener: SignaturePad.OnSignedListener) {
            view.setOnSignedListener(listener)
        }
    }
}