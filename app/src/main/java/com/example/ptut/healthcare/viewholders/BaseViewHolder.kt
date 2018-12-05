package com.mmgoogleexpert.ptut.listitemcodelab.viewholders

import android.content.Context
import android.support.annotation.CallSuper
import android.support.v7.widget.RecyclerView
import android.view.View

@Suppress("LeakingThis")
abstract class BaseViewHolder<T : Any>(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
    private lateinit var current: T

    init {
        itemView.setOnClickListener(this)
    }

    @CallSuper
    open fun bindData(item: T) {
        current = item
    }
}