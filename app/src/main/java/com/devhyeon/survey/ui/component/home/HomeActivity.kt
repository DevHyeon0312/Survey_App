package com.devhyeon.survey.ui.component.home

import android.os.Bundle
import com.devhyeon.survey.databinding.ActivityHomeBinding
import com.devhyeon.survey.ui.base.BaseActivity

class HomeActivity : BaseActivity() {
    private lateinit var xml: ActivityHomeBinding

    override fun observeViewModel() {
    }

    override fun initViewBinding() {
        xml = ActivityHomeBinding.inflate(layoutInflater)
        val view = xml.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}