package com.shinto.helpintern.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.R
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlin.coroutines.coroutineContext

class AccomodationAdapter(
    private val context: Context?,
//    private val accomodationResponse: List<AccomodationDataClassItem>
) : RecyclerView.Adapter<AccomodationAdapter.Accomodationadapter>() {

    inner class Accomodationadapter(view: View) : RecyclerView.ViewHolder(view) {
        val accomHeading = view.findViewById<TextView>(R.id.hotelHeadingTxt)
        val accomPlace = view.findViewById<TextView>(R.id.hotelDesignationTxt)
        val accomFair = view.findViewById<TextView>(R.id.minmFairTxt)
        val accomPIc = view.findViewById<ImageView>(R.id.accomPic)
        val accomParkingIcon = view.findViewById<ImageView>(R.id.parkingImg)
        val accomCard = view.findViewById<LinearLayout>(R.id.accomCard)
    }

    private val diffcallback = object : DiffUtil.ItemCallback<AccomodationDataClassItem>() {
        override fun areItemsTheSame(
            oldItem: AccomodationDataClassItem,
            newItem: AccomodationDataClassItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: AccomodationDataClassItem,
            newItem: AccomodationDataClassItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffcallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Accomodationadapter {
        val view =
            LayoutInflater.from(context).inflate(R.layout.accomodation_card, parent, false)
        return Accomodationadapter(view)
    }

    override fun onBindViewHolder(holder: Accomodationadapter, position: Int) {
        holder.accomHeading.text = differ.currentList[position].name
        holder.accomPlace.text = differ.currentList[position].city
        holder.accomFair.text = differ.currentList[position].rentAmount.toString()
        val accomDesc = differ.currentList[position]
        if (differ.currentList[position].isHeating == true) context.let {
            if (context != null) {
                Glide.with(context)
                    .load(differ.currentList[position].isHeating)
                    .apply(RequestOptions().placeholder(R.drawable.parking_24).centerCrop())
                    .into(holder.accomParkingIcon)
            }
        }

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                Log.d("Res", "oooooooooooooooooo" + it.toString())
                it(accomDesc)
            }
        }

        if (this != null) context?.let {
            Glide.with(it).load(differ.currentList[position].coverPhoto)
                .apply(RequestOptions().placeholder(R.drawable.home).centerCrop())
                .into(holder.accomPIc)
        }

//        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${imageDiff.poster_path}").
//        into(holder.accomPIc)
    }

    private var onItemClickListener: ((AccomodationDataClassItem) -> Unit)? = null

    fun setOnClickListner(listener: (AccomodationDataClassItem) -> Unit) {
        Log.d("Res", "setONClicklistner")
        onItemClickListener = listener
    }

    override fun getItemCount(): Int = differ.currentList.size

}