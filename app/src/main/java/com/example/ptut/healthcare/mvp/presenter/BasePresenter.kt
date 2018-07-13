package com.example.ptut.healthcare.mvp.presenter


import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.ptut.healthcare.mvp.view.BaseView

abstract class BasePresenter<T : BaseView> : ViewModel() {

    protected var mView: T?=null
    private var mErrorLD: MutableLiveData<String>?=null

    val errorLD: MutableLiveData<String>
        get() = mErrorLD!!

    open fun initPresenter(mView: T) {
        this.mView = mView
        mErrorLD = MutableLiveData()
    }
}