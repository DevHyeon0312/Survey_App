package com.devhyeon.survey.ui.component.detail

import android.content.Intent
import android.os.Bundle
import com.devhyeon.survey.databinding.ActivitySurveyDetailBinding
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.network.model.SurveyResult
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.ui.component.create.adapter.QuestionAdapter
import com.devhyeon.survey.utils.Status
import com.devhyeon.survey.utils.hideKeyboard
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivitySurveyDetailBinding
    private val surveyViewModel: SurveyViewModel by viewModel()

    private var mAdapter: QuestionAdapter? = QuestionAdapter()

    override fun observeViewModel() {
        addObserve()
    }

    override fun initViewBinding() {
        binding = ActivitySurveyDetailBinding.inflate(layoutInflater)
        val view = binding.root


        binding.questList.adapter = mAdapter


        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.extras!!.get("titleId")
        System.out.println("Dev>>>>>>"+id)
        surveyViewModel.getDetailSurvey(id)
    }

    private fun addObserve() {
        with(surveyViewModel) {
            detailData.observe(this@DetailActivity) {
                when (it) {
                    is Status.Run -> {
                        binding.root.hideKeyboard()
                    }
                    is Status.Success -> {
                        val survey: SurveyResult = it.data!!
                        System.out.println("DetailActivity : "+survey)
                        binding.textView4.text = survey.resultData!!.title.title
                        mAdapter?.addItem(survey.resultData!!.questions)
                        binding.root.hideKeyboard()
                    }
                    is Status.Failure -> {
                        binding.root.hideKeyboard()
                    }
                }
            }
        }
    }
}