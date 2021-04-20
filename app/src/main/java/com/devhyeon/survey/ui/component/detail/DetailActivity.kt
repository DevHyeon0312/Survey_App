package com.devhyeon.survey.ui.component.detail

import android.os.Bundle
import com.devhyeon.survey.databinding.ActivitySurveyDetailBinding
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.network.model.ApiResult
import com.devhyeon.survey.network.model.SurveyResult
import com.devhyeon.survey.network.model.TakeResult
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.ui.component.create.adapter.QuestionAdapter
import com.devhyeon.survey.utils.Status
import com.devhyeon.survey.utils.getPreferencesLong
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
        val titleId : Long = intent.extras!!.get("titleId") as Long
        val userId = getPreferencesLong(this@DetailActivity, key = "ID", defaultValue = 0L)

        System.out.println("Dev>>>>>>" + titleId)
        surveyViewModel.getDetailSurvey(titleId)

        binding.button3.setOnClickListener {
            println("" + userId + ":" + titleId)

            surveyViewModel.getTakeSurvey(userId, titleId)
        }
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
                        System.out.println("DetailActivity : " + survey)
                        binding.textView4.text = survey.resultData!!.title.title
                        mAdapter?.addItem(survey.resultData!!.questions)
                        binding.root.hideKeyboard()
                    }
                    is Status.Failure -> {
                        binding.root.hideKeyboard()
                    }
                }
            }

            takeResultData.observe(this@DetailActivity) {
                when (it) {
                    is Status.Run -> {
                        println("run")
                    }
                    is Status.Success -> {
                        val takeResult: TakeResult = it.data!!
                        println(takeResult)
                    }
                    is Status.Failure -> {
                        println("error")
                    }
                }
            }
        }
    }
}