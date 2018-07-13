package com.example.ptut.healthcare.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.ptut.healthcare.R
import com.example.ptut.healthcare.adapter.base.BaseRecyclerAdapter
import com.example.ptut.healthcare.deligate.TapItem
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
import com.example.ptut.healthcare.viewmodels.HealthCareInfoViewHolder
import com.example.ptut.healthcare.viewmodels.base.BaseViewHolder

class HealthCareInfoAdapter(context: Context,private val tapItem: TapItem)
    : BaseRecyclerAdapter<HealthCareInfoViewHolder, HealthcareInfoItem>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthcareInfoItem> {
       val view: View =mLayoutInflator.inflate(R.layout.content_item,parent,false)
        return HealthCareInfoViewHolder(view,tapItem)
    }
}