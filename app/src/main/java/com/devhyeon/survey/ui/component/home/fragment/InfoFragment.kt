package com.devhyeon.survey.ui.component.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.devhyeon.survey.data.developer.devGit
import com.devhyeon.survey.data.developer.devImage
import com.devhyeon.survey.data.developer.devName
import com.devhyeon.survey.data.developer.devType
import com.devhyeon.survey.databinding.FragmentHomeInfoBinding
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class InfoFragment : BaseFragment() {
    private var _binding: FragmentHomeInfoBinding? = null
    private val xml get() = _binding!!

    override fun observeViewModel() {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeInfoBinding.inflate(inflater, container, false)

        devHyeonInit()

        return xml.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun devHyeonInit() {
        Glide.with(this).load(devImage).into(xml.ivDeveloper)
        xml.tvDevName.text = devName
        xml.tvDevType.text = devType
        xml.tvDevGit.text = devGit
    }
}