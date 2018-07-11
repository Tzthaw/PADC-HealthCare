package com.example.ptut.padc_harecare.viewmodels


import android.view.View
import com.bumptech.glide.Glide
import com.example.ptut.padc_harecare.deligate.TapItem
import com.example.ptut.padc_harecare.persistence.entities.HealthcareInfoItem
import com.example.ptut.padc_harecare.viewmodels.base.BaseViewHolder
import kotlinx.android.synthetic.main.content_item.view.*

class HealthCareInfoViewHolder(itemView: View,private val tapItem: TapItem):
        BaseViewHolder<HealthcareInfoItem>(itemView) {
    private var healthItem:HealthcareInfoItem?=null
    override fun setData(data: HealthcareInfoItem) {
        healthItem=data
        itemView.publishDate.text =data.publishedDate
        itemView.title.text =data.title.toString()
        Glide.with(itemView)
                .load(data.image)
                .into(itemView.image)
        itemView.shortDesc.text = data.shortDescription.toString()
    }
    override fun onClick(v: View?) {
        tapItem.onTapItem(healthItem!!.completeUrl)
    }
}