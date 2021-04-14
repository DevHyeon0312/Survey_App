package com.devhyeon.survey.ui.component.login

import android.content.Intent
import android.os.Bundle
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.ActivityLoginBinding
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.ui.component.home.HomeActivity
import com.devhyeon.survey.utils.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created By DevHyeon on 2021.04.08
 * 로그인 화면 : 인터넷이 연결되어 있는 경우에 현재시간을 받아오며, 처음 로그인하는 시간을 ID 로 사용합니다. (SharedPreferences)
 * */
class LoginActivity : BaseActivity() {
    private val loginViewModel: LoginViewModel by viewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun observeViewModel() {
        loginObserve()
    }
    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.login.setOnClickListener { loginViewModel.doLogin() }
    }

    private fun loginObserve() {
        loginViewModel.loginData.observe(this@LoginActivity) {
            when(it) {
                is Status.Run -> {
                    binding.loaderView.toVisible()
                    binding.login.toGone()
                    binding.message.toGone()
                }
                is Status.Success -> {
                    binding.loaderView.toGone()
                    navigateToHomeScreen()
                }
                is Status.Failure -> {
                    binding.loaderView.toGone()
                    binding.login.toVisible()
                    binding.message.toVisible()
                    if (it.errorCode == 1) {
                        binding.root.showSnackbar(getString(R.string.default_error),1000)
                    } else if (it.errorCode == 2) {
                        binding.root.showSnackbar(getString(R.string.no_internet),1000)
                    }
                }
            }
        }
    }

    /** 홈화면으로 이동 */
    private fun navigateToHomeScreen() {
        val nextScreenIntent = Intent(this, HomeActivity::class.java)
        startActivity(nextScreenIntent)
        finish()
    }
}