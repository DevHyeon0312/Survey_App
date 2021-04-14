package com.devhyeon.survey.ui.component.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devhyeon.survey.network.model.Answer
import com.devhyeon.survey.network.model.Question
import com.devhyeon.survey.utils.Status
import kotlinx.coroutines.launch

class CreateViewModel  : ViewModel() {
    val dialogData = MutableLiveData<Status<Question>>()
    fun createQuestion(title:String, mA:String, mB:String, mC:String, mD:String) {
        lateinit var question : Question
        viewModelScope.launch {
            runCatching {
                val answers = listOf(Answer(0,mA),
                    Answer(0,mB),
                    Answer(0,mC),
                    Answer(0,mD)).filter { item -> item.answer_msg.isNotBlank() }
                var idx = 1
                for (item in answers) {
                    item.answer_id = idx++
                }
                question = Question(-1,title, answers)
                dialogData.value = Status.Run()
            }.onSuccess {
                dialogData.value = Status.Success(question)
            }.onFailure {
                dialogData.value = Status.Failure(-1)
            }
        }
    }
}