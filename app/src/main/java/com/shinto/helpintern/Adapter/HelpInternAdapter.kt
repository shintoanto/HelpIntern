package com.shinto.helpintern

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shinto.helpintern.Data.Get.JobListDataClass
import com.shinto.helpintern.Ui.Job_fragment

class HelpInternrecycler(
    private val jobResponse: List<JobListDataClass>?,
    private val context: Context?,
    navController: NavController
) :
    RecyclerView.Adapter<HelpInternrecycler.HelpInternViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HelpInternrecycler.HelpInternViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.jobscardview, parent, false)

        return HelpInternViewHolder(view)
    }

    inner class HelpInternViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val heading = view.findViewById<TextView>(R.id.headingTxt)
        val designation = view.findViewById<TextView>(R.id.designationTxt)
        val minimumWage = view.findViewById<TextView>(R.id.minmWageTxt)
        val jobCard = view.findViewById<LinearLayout>(R.id.jobCard)
    }

    private val diffcallback = object : DiffUtil.ItemCallback<JobListDataClass>() {
        override fun areItemsTheSame(
            oldItem: JobListDataClass,
            newItem: JobListDataClass
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: JobListDataClass,
            newItem: JobListDataClass
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffcallback)

    override fun onBindViewHolder(holder: HelpInternrecycler.HelpInternViewHolder, position: Int) {
        holder.heading.text = jobResponse?.get(position)?.company_name
        holder.designation.text = jobResponse?.get(position)?.designation
        // holder.tenTxt.text = jobResponse?.get(position)?.provider.toString()
        holder.minimumWage.text = jobResponse?.get(position)?.minimum_wage.toString()
        holder.jobCard
        holder.jobCard.setOnClickListener {
         //  val navController = findNavController()
        }
        holder.itemView.setOnClickListener{

            onItemClickListener
        }
    }

    private var onItemClickListener: ((JobListDataClass) -> Unit)? = null

    fun setItemClickListner(listener: (JobListDataClass) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return jobResponse?.size!!
    }

}