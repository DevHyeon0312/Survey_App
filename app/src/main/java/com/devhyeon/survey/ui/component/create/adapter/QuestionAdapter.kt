package com.devhyeon.survey.ui.component.create.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devhyeon.survey.R
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.devhyeon.survey.data.dto.Question
import com.devhyeon.survey.databinding.ItemQustionBinding
import okhttp3.internal.notify
import kotlin.properties.Delegates


class QuestionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mPostList: MutableList<Question> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemQuestionBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_qustion, parent, false
        )
        return QuestionViewHolder(itemQuestionBinding)
    }

    override fun getItemCount(): Int = if (mPostList.isNullOrEmpty()) 0 else mPostList.size

    private fun getItem(position: Int): Question = mPostList[position]

    fun addItem(question: Question) {
        question.question_id = mPostList.size+1
        mPostList.add(question)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as QuestionViewHolder).onBind(getItem(position))
    }

    private inner class QuestionViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun onBind(question: Question) {
            (viewDataBinding as ItemQustionBinding).question = question
        }
    }
}

