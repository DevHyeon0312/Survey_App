package com.devhyeon.survey.ui.component.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.ActivityHomeBinding.bind
import com.devhyeon.survey.databinding.ItemTitleBinding
import com.devhyeon.survey.network.model.Survey
import okhttp3.internal.notifyAll
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.properties.Delegates


class TitlesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mPostList: List<Survey> by Delegates.observable(emptyList()) { _,_,_ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemTitleBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_title, parent, false
        )
        return SurveyViewHolder(itemTitleBinding)
    }

    override fun getItemCount(): Int = if (mPostList.isNullOrEmpty()) 0 else mPostList.size

    private fun getItem(position: Int): Survey = mPostList[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SurveyViewHolder).onBind(getItem(position))
    }

    private inner class SurveyViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun onBind(survey: Survey) {
            (viewDataBinding as ItemTitleBinding).survey = survey
        }
    }
}

