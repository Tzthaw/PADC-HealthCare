package com.example.ptut.padc_harecare.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.ptut.padc_harecare.R
import com.example.ptut.padc_harecare.adapter.base.BaseRecyclerAdapter
import com.example.ptut.padc_harecare.deligate.TapItem
import com.example.ptut.padc_harecare.persistence.entities.HealthcareInfoItem
import com.example.ptut.padc_harecare.viewmodels.HealthCareInfoViewHolder
import com.example.ptut.padc_harecare.viewmodels.base.BaseViewHolder

class HealthCareInfoAdapter(context: Context,private val tapItem: TapItem)
    : BaseRecyclerAdapter<HealthCareInfoViewHolder, HealthcareInfoItem>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthcareInfoItem> {
       val view: View =mLayoutInflator.inflate(R.layout.content_item,parent,false)
        return HealthCareInfoViewHolder(view,tapItem);
    }
}