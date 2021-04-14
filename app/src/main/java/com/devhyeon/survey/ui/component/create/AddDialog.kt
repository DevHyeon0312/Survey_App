package com.devhyeon.survey.ui.component.create

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import com.devhyeon.survey.databinding.DialogSurveyAdditemBinding

class AddDialog(val context: Context, val createViewModel: CreateViewModel) {
    private lateinit var binding: DialogSurveyAdditemBinding

    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감

    fun start() {
        binding = DialogSurveyAdditemBinding.inflate(LayoutInflater.from(context))
        val view = binding.root
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setContentView(view)
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함

        binding.button3.setOnClickListener {
            dlg.dismiss()
        }

        binding.button4.setOnClickListener {
            createViewModel.createQuestion(
                binding.textView6.text.toString(),
                binding.radioButton.text.toString(),
                binding.radioButton2.text.toString(),
                binding.radioButton3.text.toString(),
                binding.radioButton4.text.toString())
            dlg.dismiss()
        }
        dlg.show()
    }
}