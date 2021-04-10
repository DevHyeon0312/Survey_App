package com.devhyeon.survey.ui.component.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.FragmentHomeInfoBinding
import com.devhyeon.survey.databinding.FragmentHomeSurveyBinding
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.network.model.Survey
import com.devhyeon.survey.ui.base.BaseFragment
import com.devhyeon.survey.ui.component.home.adapter.TitlesAdapter
import com.devhyeon.survey.utils.Status
import com.devhyeon.survey.utils.toGone
import com.devhyeon.survey.utils.toVisible
import org.koin.android.viewmodel.ext.android.viewModel

class SurveyFragment(val surveyViewModel : SurveyViewModel) : BaseFragment() {
    private var _binding: FragmentHomeSurveyBinding? = null
    private val xml get() = _binding!!

    private var mAdapter: TitlesAdapter? = TitlesAdapter()

    override fun observeViewModel() {
        surveyObserve()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeSurveyBinding.inflate(inflater, container, false)

        observeViewModel()

        xml.rvTitles.adapter = mAdapter

        return xml.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun surveyObserve() {
        surveyViewModel.statusData.observe(this@SurveyFragment, Observer {
            when (it) {
                is Status.Run -> {
                    xml.loaderView.toVisible()
                    xml.titlesView.toGone()
                }
                is Status.Success -> {
                    xml.loaderView.toGone()
                    xml.titlesView.toVisible()
                    mAdapter?.mPostList = it.data!!
                }
                is Status.Failure -> {
                    xml.loaderView.toVisible()
                    xml.titlesView.toGone()
                }
            }
        })
    }
}