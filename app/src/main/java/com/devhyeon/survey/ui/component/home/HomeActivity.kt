package com.devhyeon.survey.ui.component.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.ActivityHomeBinding
import com.devhyeon.survey.network.SurveyViewModel
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.ui.component.home.fragment.HomeFragment
import com.devhyeon.survey.ui.component.home.fragment.InfoFragment
import com.devhyeon.survey.ui.component.home.fragment.SurveyFragment
import com.devhyeon.survey.utils.Status
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    private val homeFragment by lazy { HomeFragment() }
    private val surveyFragment by lazy { SurveyFragment() }
    private val infoFragment by lazy { InfoFragment() }

    override fun observeViewModel() {
        navigationObserve()
    }

    override fun initViewBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.bottomNavigationView.run {
            setOnNavigationItemSelectedListener {
                homeViewModel.clickNavigation(it.itemId)
                true
            }
            selectedItemId = R.id.menu_home
        }
    }


    private fun navigationObserve() {
        with(homeViewModel) {
            navigationData.observe(this@HomeActivity, Observer {
                when(it) {
                    is Status.Run -> {}
                    is Status.Success -> {
                        when(it.data) {
                            1 -> {
                                changeFragment(homeFragment)

                            }
                            2 -> {
                                changeFragment(surveyFragment)
                            }
                            3 -> {
                                changeFragment(infoFragment)
                            }
                        }
                    }
                    is Status.Failure -> {}
                }
            })
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fl_container, fragment).commit()
    }
}