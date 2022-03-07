package com.shinto.helpintern

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shinto.helpintern.Data.JobListDataClass

class HelpInternrecycler : RecyclerView.Adapter<HelpInternrecycler.HelpInternViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HelpInternrecycler.HelpInternViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jobscardview,parent,false)
        return HelpInternViewHolder(view)
    }

    inner class HelpInternViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    private val diffcallback = object : DiffUtil.ItemCallback<JobListDataClass>(){
        override fun areItemsTheSame(oldItem: JobListDataClass, newItem: JobListDataClass): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JobListDataClass, newItem: JobListDataClass): Boolean {
            return oldItem == newItem
        }
    }
    val differ= AsyncListDiffer(this,diffcallback)

    override fun onBindViewHolder(holder: HelpInternrecycler.HelpInternViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    private var onItemClickListener: ((JobListDataClass) -> Unit)? = null

    fun setOnClickListner(listener: (JobListDataClass) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}