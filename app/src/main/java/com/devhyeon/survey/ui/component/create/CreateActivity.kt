package com.devhyeon.survey.ui.component.create

import android.os.Bundle
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.ActivitySurveyCreateBinding
import com.devhyeon.survey.ui.base.BaseActivity

class CreateActivity : BaseActivity() {
    private lateinit var xml: ActivitySurveyCreateBinding

    override fun observeViewModel() { }

    override fun initViewBinding() {
        xml = ActivitySurveyCreateBinding.inflate(layoutInflater)
        val view = xml.root
        setContentView(view)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}