package com.shinto.helpintern.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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
        val accomPIc =view.findViewById<ImageView>(R.id.accomPic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Accomodationadapter {
        val view = LayoutInflater.from(context).inflate(R.layout.accomodation_card, parent, false)
        return Accomodationadapter(view)
    }

    override fun onBindViewHolder(holder: Accomodationadapter, position: Int) {
        holder.accomHeading.text = accomodationResponse[position].name
        holder.accomPlace.text = accomodationResponse[position].city
        holder.accomFair.text = accomodationResponse[position].rentAmount.toString()
        if (context != null) {
            Glide.with(context).load(accomodationResponse[position].coverPhoto)
                .apply(RequestOptions().placeholder(R.drawable.home_24).centerCrop()).into(holder.accomPIc)
        }
//        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${imageDiff.poster_path}").
//        into(holder.accomPIc)
    }

    override fun getItemCount(): Int = accomodationResponse.size

}