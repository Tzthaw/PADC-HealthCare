package com.example.ptut.padc_harecare.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.example.ptut.padc_harecare.R
import com.example.ptut.padc_harecare.activities.base.BaseActivity
import com.example.ptut.padc_harecare.adapter.HealthCareInfoAdapter
import com.example.ptut.padc_harecare.mvp.presenter.HealthCarePresenter
import com.example.ptut.padc_harecare.mvp.view.HealthCareInfoView
import com.example.ptut.padc_harecare.persistence.entities.HealthcareInfoItem
import com.example.ptut.padc_harecare.utils.CustomTabActivityHelper
import com.example.ptut.padc_harecare.utils.WebviewFallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_item.*

class MainActivity : BaseActivity(),HealthCareInfoView {

    private lateinit var healthPresenter: HealthCarePresenter
    private var healthAdapter: HealthCareInfoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        healthPresenter=ViewModelProviders.of(this@MainActivity).get(HealthCarePresenter::class.java)
        healthPresenter.initPresenter(this@MainActivity)
        healthPresenter.errorLD.observe(this@MainActivity,this@MainActivity)

        healthAdapter= HealthCareInfoAdapter(applicationContext, healthPresenter)
        healthCareRecycler.layoutManager=LinearLayoutManager(applicationContext)
        healthCareRecycler.adapter=healthAdapter

        healthPresenter.healthcareLD.observe(this, Observer<List<HealthcareInfoItem>> {
            healthcareInfoItems -> healthAdapter!!.setNewData(healthcareInfoItems as MutableList<HealthcareInfoItem>) })

    }
    override fun lunchCompleteUrl(s: String) {
        val customTabsIntent = CustomTabsIntent.Builder().build()
        CustomTabActivityHelper.openCustomTab(
                this@MainActivity, customTabsIntent, Uri.parse(s), WebviewFallback())
    }

    override fun onChanged(t: String?) {
        Snackbar.make(view, t.toString(),Snackbar.LENGTH_SHORT)
    }
}
