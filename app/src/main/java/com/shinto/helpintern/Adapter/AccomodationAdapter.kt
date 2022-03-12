package com.shinto.helpintern.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shinto.helpintern.R
import kotlin.coroutines.coroutineContext

class AccomodationAdapter(private val context: Context?) : RecyclerView.Adapter<AccomodationAdapter.Accomodationadapter>() {

    inner class Accomodationadapter(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Accomodationadapter {
     val view = LayoutInflater.from(context).inflate(R.layout.)
    }

    override fun onBindViewHolder(holder: Accomodationadapter, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}