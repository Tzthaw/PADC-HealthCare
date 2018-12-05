package com.example.ptut.healthcare.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
import com.mmgoogleexpert.ptut.listitemcodelab.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.content_item.view.*

class HealthInfoViewHolder(itemView: View):
        BaseViewHolder<HealthcareInfoItem>(itemView) {
    private val tvTitle = itemView.title
    private val ivImage = itemView.image
    private val tvDesc = itemView.shortDesc

    override fun bindData(item: HealthcareInfoItem) {
        super.bindData(item)
        // bind data here
        tvTitle.text = item.title
        tvDesc.text = item.shortDescription
        Glide.with(itemView)
                .load(item.image)
                .into(itemView.image)
    }
    override fun onClick(p0: View?) {

    }
}