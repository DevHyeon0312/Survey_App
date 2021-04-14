package com.devhyeon.survey.ui.component.home.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.FragmentHomeHomeBinding
import com.devhyeon.survey.ui.base.BaseFragment
import com.devhyeon.survey.ui.component.create.CreateActivity
import com.devhyeon.survey.ui.component.home.HomeActivity


class HomeFragment : BaseFragment() {
    private var _binding: FragmentHomeHomeBinding? = null
    private val binding get() = _binding!!

    override fun observeViewModel() {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeHomeBinding.inflate(inflater, container, false)
        binding.textView.text="어서오세요,\n설문생성과 참여로 마음껏 즐겨보세요"
        binding.button2.setOnClickListener { navigateToCreateScreen() }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /** 생성화면으로 이동 */
    private fun navigateToCreateScreen() {
        activity?.let{
            val intent = Intent (it, CreateActivity::class.java)
            it.startActivity(intent)
        }
    }
}