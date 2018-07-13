package com.example.ptut.healthcare.mvp.presenter


import android.arch.lifecycle.MutableLiveData
import com.example.ptut.healthcare.deligate.TapItem
import com.example.ptut.healthcare.model.HealthCareInfoModel
import com.example.ptut.healthcare.mvp.view.HealthCareInfoView
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem

class HealthCarePresenter : BasePresenter<HealthCareInfoView>(),TapItem {

    private var mHealthCareLD: MutableLiveData<List<HealthcareInfoItem>>?=null

    override fun initPresenter(mView: HealthCareInfoView) {
        super.initPresenter(mView)
        mHealthCareLD = MutableLiveData()
        HealthCareInfoModel.getInstance().getHealthCareInfoItem(mHealthCareLD!!, errorLD)
    }

    val healthcareLD: MutableLiveData<List<HealthcareInfoItem>>
        get() = mHealthCareLD!!

    override fun onTapItem(s: String?) {
        mView!!.lunchCompleteUrl(s!!)
    }


}
