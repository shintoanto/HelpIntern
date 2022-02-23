package com.shinto.helpintern

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

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
//    private val diffcallback = object : DiffUtil.ItemCallback<Result>(){
//        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
//            return oldItem == newItem
//        }
//    }
//    val differ= AsyncListDiffer(this,diffcallback)

    override fun onBindViewHolder(holder: HelpInternrecycler.HelpInternViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

//    private var onItemClickListener: ((Result) -> Unit)? = null
//
//    fun setOnClickListner(listener: (Result) -> Unit) {
//        onItemClickListener = listener
//    }
//    override fun getItemCount(): Int {
//        return differ.currentList.size
//    }
//
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}