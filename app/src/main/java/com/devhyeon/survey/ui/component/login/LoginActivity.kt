package com.devhyeon.survey.ui.component.login

import android.os.Bundle
import com.devhyeon.survey.databinding.ActivityLoginBinding
import com.devhyeon.survey.ui.base.BaseActivity
import com.devhyeon.survey.utils.Status
import org.koin.android.viewmodel.ext.android.viewModel

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
        binding.login.setOnClickListener { doLogin() }
    }

    /** 로그인 시도 */
    private fun doLogin() {
        loginViewModel.doLogin("202104081631001")
    }

    private fun loginObserve() {
        loginViewModel.loginData.observe(this) {
            when(it) {
                is Status.Run -> System.out.println("Loading..")
                is Status.Success -> System.out.println("Success")
                is Status.Failure -> System.out.println("Failure")
            }
        }
    }

//
//
//
//

//
//    /** 로그인 결과 처리 */
//    private fun handleLoginResult(status: Resource<LoginResponse>) {
//        when (status) {
//            is Resource.Loading -> {
//                binding.loaderView.toVisible()
//            }
//            is Resource.Success -> status.data?.let {
//                binding.loaderView.toGone()
//                navigateToHomeScreen()
//            }
//            is Resource.DataError -> {
//                binding.loaderView.toGone()
////                status.errorCode?.let {
////                    loginViewModel.showSnackBarMessage(it)
////                }
//            }
//        }
//    }
//
//    /** 홈화면으로 이동 */
//    private fun navigateToHomeScreen() {
//        val nextScreenIntent = Intent(this, HomeActivity::class.java)
//        startActivity(nextScreenIntent)
//        finish()
//    }
//
//    private fun observeSnackBarMessages(event: LiveData<SingleEvent<Any>>) {
//        binding.root.setupSnackbar(this, event, Snackbar.LENGTH_LONG)
//    }
}