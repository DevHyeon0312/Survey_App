package com.devhyeon.survey.ui.component.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.devhyeon.survey.SPLASH_DELAY
import com.devhyeon.survey.databinding.ActivitySplashBinding
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.ui.component.login.LoginActivity


/**
 * Created By DevHyeon on 2021.04.08
 * 스플래쉬 화면 : Constants.SPLASH_DELAY 밀리초 후에 다음 단계를 진행합니다.
 * */

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun observeViewModel() {}
    override fun initViewBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToLoginScreen()
    }

    /** 로그인 화면으로 이동 */
    private fun navigateToLoginScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val nextScreenIntent = Intent(this, LoginActivity::class.java)
            startActivity(nextScreenIntent)
            finish()
        }, SPLASH_DELAY.toLong())
    }
}
