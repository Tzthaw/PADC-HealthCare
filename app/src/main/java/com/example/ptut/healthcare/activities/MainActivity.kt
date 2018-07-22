package com.example.ptut.healthcare.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.example.ptut.healthcare.R
import com.example.ptut.healthcare.activities.base.BaseActivity
import com.example.ptut.healthcare.adapter.HealthCareInfoAdapter
import com.example.ptut.healthcare.mvp.presenter.HealthCarePresenter
import com.example.ptut.healthcare.mvp.view.HealthCareInfoView
import com.example.ptut.healthcare.persistence.entities.HealthcareInfoItem
import com.example.ptut.healthcare.utils.CustomTabActivityHelper
import com.example.ptut.healthcare.utils.WebviewFallback
import com.padcmyanmar.mmnews.kotlin.components.SmartScrollListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),HealthCareInfoView {

    private lateinit var healthPresenter: HealthCarePresenter
    private lateinit var healthAdapter: HealthCareInfoAdapter
    private var mSmartScrollListener: SmartScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declare Data Presenter
        //show data and error
        swipeRefreshLayout.isRefreshing = true
        healthPresenter=ViewModelProviders.of(this@MainActivity).get(HealthCarePresenter::class.java)
        healthPresenter.initPresenter(this@MainActivity)
        healthPresenter.onNotifyFinishSetup()
        healthPresenter.errorLD.observe(this@MainActivity, this)

        //initial setup for adapter
        healthCareRecycler.setEmptyView(emptyLayout)
        healthAdapter= HealthCareInfoAdapter(applicationContext, healthPresenter)
        healthCareRecycler.layoutManager=LinearLayoutManager(applicationContext)

        //List end reach loading more data
        mSmartScrollListener = SmartScrollListener(object : SmartScrollListener.OnSmartScrollListener {
            override fun onListEndReach() {
                Snackbar.make(healthCareRecycler, "Loading More Data", Snackbar.LENGTH_SHORT).show()
                swipeRefreshLayout.isRefreshing = true
                 healthPresenter.onForceRefresh()
            }
        })

        healthCareRecycler.addOnScrollListener(mSmartScrollListener)
        healthCareRecycler.adapter=healthAdapter
        healthPresenter.healthcareLD.observe(this, Observer<List<HealthcareInfoItem>> {
            healthcareInfoItems ->
            swipeRefreshLayout.isRefreshing=false
            healthAdapter.setNewData(healthcareInfoItems as MutableList<HealthcareInfoItem>) })

        //Pull to refresh data
        swipeRefreshLayout.setOnRefreshListener {
           healthPresenter.onForceRefresh()
        }

    }
    override fun lunchCompleteUrl(s: String) {
        val customTabsIntent = CustomTabsIntent.Builder().build()
        CustomTabActivityHelper.openCustomTab(
                this@MainActivity, customTabsIntent, Uri.parse(s), WebviewFallback())
    }
}
