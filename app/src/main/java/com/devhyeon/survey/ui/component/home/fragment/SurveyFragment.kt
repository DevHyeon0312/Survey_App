package com.devhyeon.survey.ui.component.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.FragmentHomeInfoBinding
import com.devhyeon.survey.databinding.FragmentHomeSurveyBinding
import com.devhyeon.survey.ui.base.BaseFragment

class SurveyFragment : BaseFragment() {
    private var _binding: FragmentHomeSurveyBinding? = null
    private val xml get() = _binding!!

    override fun observeViewModel() {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeSurveyBinding.inflate(inflater, container, false)
        return xml.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}