package com.devhyeon.survey.ui.component.create

import android.os.Bundle
import android.widget.Toast
import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.databinding.ActivitySurveyCreateBinding
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.ui.component.create.adapter.QuestionAdapter
import com.devhyeon.survey.utils.Status
import com.devhyeon.survey.utils.hideKeyboard
import org.koin.android.viewmodel.ext.android.viewModel

class CreateActivity : BaseActivity() {
    private lateinit var binding: ActivitySurveyCreateBinding
    private val createViewModel: CreateViewModel by viewModel()
    private val surveyViewModel: SurveyViewModel by viewModel()

    private var mAdapter: QuestionAdapter? = QuestionAdapter()

    override fun observeViewModel() {
        addObserve()
    }

    override fun initViewBinding() {
        binding = ActivitySurveyCreateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.questList.adapter = mAdapter

        binding.floatingActionButton.setOnClickListener {
            AddDialog(this, createViewModel).start()
        }

        binding.button3.setOnClickListener {
            var survey = Survey(
                binding.textView4.text.toString(),
                mAdapter!!.mPostList
            )
            surveyViewModel.postCreateSurvey(survey)
            System.out.println(survey.toString())
        }
    }

    private fun addObserve() {
        with(createViewModel) {
            dialogData.observe(this@CreateActivity) {
                when (it) {
                    is Status.Run -> {
                        binding.root.hideKeyboard()
                    }
                    is Status.Success -> {
                        mAdapter?.addItem(it.data!!)
                        binding.root.hideKeyboard()
                    }
                    is Status.Failure -> {
                        binding.root.hideKeyboard()
                    }
                }
            }
        }

        with(surveyViewModel) {
            createdData.observe(this@CreateActivity) {
                when(it) {
                    is Status.Run -> {
                        binding.root.hideKeyboard()
                    }
                    is Status.Success -> {
                        Toast.makeText(this@CreateActivity,"SUCCESS",Toast.LENGTH_SHORT)
                        binding.root.hideKeyboard()
                        finish()
                    }
                    is Status.Failure -> {
                        Toast.makeText(this@CreateActivity,"FAIL",Toast.LENGTH_SHORT)
                        binding.root.hideKeyboard()
                    }
                }
            }
        }
    }
}