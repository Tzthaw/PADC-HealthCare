package com.mmgoogleexpert.ptut.listitemcodelab.adapters

import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.example.ptut.healthcare.R
import com.example.ptut.healthcare.adapter.inflate
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
import com.example.ptut.healthcare.viewholders.HealthInfoViewHolder

val diffUtil = object : DiffUtil.ItemCallback<HealthcareInfoItem>(){
    override fun areItemsTheSame(oldItem: HealthcareInfoItem, newItem: HealthcareInfoItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HealthcareInfoItem, newItem: HealthcareInfoItem): Boolean {
        return oldItem == newItem
    }
}
class HealthAdapter :BaseAdapter<HealthInfoViewHolder, HealthcareInfoItem>(diffUtil){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthInfoViewHolder {
        return HealthInfoViewHolder(parent.inflate(R.layout.content_item))
    }
}