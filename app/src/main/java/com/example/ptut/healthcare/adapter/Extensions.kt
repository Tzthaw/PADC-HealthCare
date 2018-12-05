package com.example.ptut.healthcare.adapter

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ptut.healthcare.component.EmptyViewPod
import com.padcmyanmar.mmnews.kotlin.components.SmartRecyclerView


fun SmartRecyclerView.setUpRecycler(context: Context, emptyViewPod: EmptyViewPod){
    hasFixedSize()
    layoutManager= android.support.v7.widget.LinearLayoutManager(context)
    adapter?.notifyDataSetChanged()
    scheduleLayoutAnimation()
    setEmptyView(emptyViewPod)
}

fun <T> lazySafety(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)

inline fun <reified T : ViewModel> Fragment.getViewModel(): T {
    return ViewModelProviders.of(this)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(): T {
    return ViewModelProviders.of(this)[T::class.java]
}


fun ViewGroup.inflate(layoutId: Int): View = LayoutInflater.from(this.context).inflate(layoutId, this, false)
