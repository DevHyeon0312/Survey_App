package com.devhyeon.survey.ui.component.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.FragmentHomeInfoBinding
import com.devhyeon.survey.databinding.FragmentHomeSurveyBinding
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class SurveyFragment : BaseFragment() {
    private val surveyViewModel : SurveyViewModel by viewModel()

    private var _binding: FragmentHomeSurveyBinding? = null
    private val xml get() = _binding!!

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

//        surveyViewModel.getSurveys()

        surveyViewModel.getDetail(1)

        return xml.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun surveyObserve() {
        with(surveyViewModel) {
            postsData.observe(this@SurveyFragment, Observer {
//                activityPostsBinding.postsProgressBar.visibility = GONE
                xml.textView.text = it.toString()
            })

            messageData.observe(this@SurveyFragment, Observer {
//                Toast.makeText(this@PostsActivity, it, LENGTH_LONG).show()
                java.lang.System.out.println("DevMessage"+it.toString())
            })

            showProgressbar.observe(this@SurveyFragment, Observer { isVisible ->
//                posts_progress_bar.visibility = if (isVisible) VISIBLE else GONE
            })
        }
    }
}