package com.devhyeon.survey.ui.component.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.ActivityHomeBinding
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.ui.base.BaseFragment
import com.devhyeon.survey.ui.component.home.fragment.HomeFragment
import com.devhyeon.survey.ui.component.home.fragment.InfoFragment
import com.devhyeon.survey.ui.component.home.fragment.SurveyFragment
import com.devhyeon.survey.ui.component.login.LoginViewModel
import com.devhyeon.survey.utils.Status
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {
    private lateinit var xml: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    private val homeFragment by lazy { HomeFragment() }
    private val surveyFragment by lazy { SurveyFragment() }
    private val infoFragment by lazy { InfoFragment() }

    override fun observeViewModel() {
        navigationObserve()
    }

    override fun initViewBinding() {
        xml = ActivityHomeBinding.inflate(layoutInflater)
        val view = xml.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        xml.bottomNavigationView.run {
            setOnNavigationItemSelectedListener {
                homeViewModel.clickNavigation(it.itemId)
                true
            }
            selectedItemId = R.id.menu_home
        }
    }

    private fun navigationObserve() {
        homeViewModel.navigationData.observe(this) {
            when(it) {
                is Status.Run -> {}
                is Status.Success -> {
                    when(it.data) {
                        1 -> changeFragment(homeFragment)
                        2 -> changeFragment(surveyFragment)
                        3 -> changeFragment(infoFragment)
                    }
                }
                is Status.Failure -> {}
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fl_container, fragment).commit()
    }

}