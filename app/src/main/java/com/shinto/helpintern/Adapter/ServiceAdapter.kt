package com.shinto.helpintern.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.shinto.helpintern.Data.Get.ServiceListItem
import com.shinto.helpintern.R

class ServiceAdapter(
    private val ServiceResponse: List<ServiceListItem>?,
    private val context: Context?,
    navController: NavController
) : RecyclerView.Adapter<ServiceAdapter.Servicesadapter>() {

    inner class Servicesadapter(view: View) : RecyclerView.ViewHolder(view) {
        val serviceHeading = view.findViewById<TextView>(R.id.serviceHeadingTxt)
        val servicePlace = view.findViewById<TextView>(R.id.serviceDesignationTxt)
        val serviceFair = view.findViewById<TextView>(R.id.minmFairTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Servicesadapter {
        val view = LayoutInflater.from(context).inflate(R.layout.servicecard, parent, false)
        return Servicesadapter(view)
    }

    override fun onBindViewHolder(holder: Servicesadapter, position: Int) {
        holder.serviceHeading.text = ServiceResponse?.get(position)?.city
        holder.servicePlace.text = ServiceResponse?.get(position)?.country.toString()
        holder.serviceFair.text = ServiceResponse?.get(position)?.province.toString()
        holder.itemView.setOnClickListener {

        }
    }

    private var onItemClickListener: ((ServiceListItem) -> Unit)? = null

    fun setItemClickListener(listener: (ServiceListItem) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int = ServiceResponse?.size!!

}