package com.devhyeon.survey.ui.component.home.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.devhyeon.survey.R
import com.devhyeon.survey.databinding.ActivityHomeBinding.bind
import com.devhyeon.survey.databinding.ItemTitleBinding
import okhttp3.internal.notifyAll
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.devhyeon.survey.network.model.SurveyTitle
import com.devhyeon.survey.ui.component.detail.DetailActivity
import kotlin.properties.Delegates


class TitlesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var mContext : Context
    var mPostList: List<SurveyTitle> by Delegates.observable(emptyList()) { _,_,_ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemTitleBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_title, parent, false
        )
        mContext = parent.context
        return SurveyViewHolder(itemTitleBinding)
    }

    override fun getItemCount(): Int = if (mPostList.isNullOrEmpty()) 0 else mPostList.size

    private fun getItem(position: Int): SurveyTitle = mPostList[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SurveyViewHolder).onBind(getItem(position))
    }

    private inner class SurveyViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun onBind(survey: SurveyTitle) {
            (viewDataBinding as ItemTitleBinding).survey = survey
            viewDataBinding.button.setOnClickListener { navigateToDetailScreen(survey) }
        }
    }

    /** 디테일홤녀으로 이동 */
    private fun navigateToDetailScreen(survey: SurveyTitle) {
        mContext?.let{
            val intent = Intent (it, DetailActivity::class.java)
            intent.putExtra("titleId",survey.id)
            System.out.println("Dev>>>>>>"+survey.id)
            it.startActivity(intent)
        }
    }
}

