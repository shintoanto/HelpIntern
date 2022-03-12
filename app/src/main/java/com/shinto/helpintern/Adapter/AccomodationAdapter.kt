package com.shinto.helpintern.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.R
import kotlin.coroutines.coroutineContext

class AccomodationAdapter(
    private val context: Context?,
    private val accomodationResponse: List<AccomodationDataClassItem>
) : RecyclerView.Adapter<AccomodationAdapter.Accomodationadapter>() {

    inner class Accomodationadapter(view: View) : RecyclerView.ViewHolder(view) {
        val accomHeading = view.findViewById<TextView>(R.id.hotelHeadingTxt)
        val accomPlace = view.findViewById<TextView>(R.id.hotelDesignationTxt)
        val accomFair = view.findViewById<TextView>(R.id.minmFairTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Accomodationadapter {
        val view = LayoutInflater.from(context).inflate(R.layout.accomodation_card, parent, false)
        return Accomodationadapter(view)
    }

    override fun onBindViewHolder(holder: Accomodationadapter, position: Int) {
        holder.accomHeading.text = accomodationResponse[position].name
        holder.accomPlace.text = accomodationResponse[position].city
        holder.accomFair.text = accomodationResponse[position].rent_amount.toString()
    }

    override fun getItemCount(): Int = accomodationResponse.size

}