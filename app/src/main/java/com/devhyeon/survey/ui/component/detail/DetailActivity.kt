package com.devhyeon.survey.ui.component.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.size
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.ActivitySurveyDetailBinding
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.network.model.*
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.ui.component.create.adapter.QuestionAdapter
import com.devhyeon.survey.utils.*
import kotlinx.android.synthetic.main.item_qustion.view.*
import kotlinx.coroutines.delay
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivitySurveyDetailBinding
    private val surveyViewModel: SurveyViewModel by viewModel()

    private var mAdapter: QuestionAdapter? = QuestionAdapter()

    var titleId : Long? = null
    var userId : Long? = null
    override fun observeViewModel() {
        addObserve()
    }

    override fun initViewBinding() {
        binding = ActivitySurveyDetailBinding.inflate(layoutInflater)
        val view = binding.root

        binding.join.questList.adapter = mAdapter

        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        titleId = intent.extras!!.get("titleId") as Long
        userId = getPreferencesLong(this@DetailActivity, key = "ID", defaultValue = 0L)

        surveyViewModel.getTakeSurvey(userId, titleId)

        System.out.println("onCreated" + titleId)

        binding.join.button3.setOnClickListener {
            println("" + userId + ":" + titleId)
            //TODO : 설문 참여 실행
            var mAnsList: MutableList<UserAns> = mutableListOf()

            var count = 0
            for (i in 0 until mAdapter!!.itemCount) {
                val radioButtonID: Int = binding.join.questList.get(i).radioGroup.checkedRadioButtonId
                if(radioButtonID == -1) {
                    break
                }
                val radioButton: View = binding.join.questList.get(i).radioGroup.findViewById(radioButtonID)
                val idx: Int = binding.join.questList.get(i).radioGroup.indexOfChild(radioButton)

                count = if (idx != -1) count+1 else count

                mAnsList.add(UserAns((i+1).toLong(),(idx+1).toLong()))
            }

            val take = Take(userId!!,titleId!!,mAnsList,null)
            surveyViewModel.postTakeSurvey(take, count, mAdapter!!.itemCount)
        }
    }

    private fun addObserve() {
        with(surveyViewModel) {
            detailData.observe(this@DetailActivity) {
                when (it) {
                    is Status.Run -> {
                        println("detailData run")
                        binding.loaderView.toVisible()
                        binding.root.hideKeyboard()
                    }
                    is Status.Success -> {
                        println("detailData success")
                        binding.loaderView.toGone()
                        val survey: SurveyResult = it.data!!
                        System.out.println("DetailActivity : " + survey)
                        binding.join.textView4.text = survey.resultData!!.title.title
                        mAdapter?.addItem(survey.resultData!!.questions)
                        binding.root.hideKeyboard()
                    }
                    is Status.Failure -> {
                        println("detailData fail")
                        binding.loaderView.toGone()
                        binding.root.hideKeyboard()
                    }
                }
            }
        }

        with(surveyViewModel) {
            takeResultData.observe(this@DetailActivity) {
                when (it) {
                    is Status.Run -> {
                        println("takeResultData run")
                        binding.loaderView.toVisible()
                    }
                    is Status.Success -> {
                        println("takeResultData success")
                        binding.loaderView.toGone()
                        val takeResult: TakeResult = it.data!!
                        println(takeResult)
                        if (takeResult.resultData == null) {
                            surveyViewModel.getDetailSurvey(titleId)
                            binding.join.root.toVisible()
                            binding.result.root.toGone()
                        } else {
                            //TODO: 참여결과 삽입
                            binding.join.root.toGone()
                            binding.result.root.toVisible()
                        }
                    }
                    is Status.Failure -> {
                        println("takeResultData fuail")
                        binding.loaderView.toGone()
                    }
                }
            }
        }

        with(surveyViewModel) {
            takeData.observe(this@DetailActivity) {
                when(it) {
                    is Status.Run -> {
                        binding.loaderView.toVisible()
                    }
                    is Status.Success -> {
                        binding.loaderView.toGone()
                        Toast.makeText(this@DetailActivity,"참여완료",Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    is Status.Failure -> {
                        Toast.makeText(this@DetailActivity,"참여실패",Toast.LENGTH_SHORT).show()
                        binding.loaderView.toGone()
                    }
                }
            }
        }
    }
}