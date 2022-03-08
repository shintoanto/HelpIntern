package com.shinto.helpintern

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shinto.helpintern.Data.JobListDataClass
import org.w3c.dom.Text

class HelpInternrecycler(val jobResponse: List<JobListDataClass>?, val context: Context?) :
    RecyclerView.Adapter<HelpInternrecycler.HelpInternViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HelpInternrecycler.HelpInternViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.jobscardview, parent, false)
        return HelpInternViewHolder(view)
    }

    inner class HelpInternViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Heading = view.findViewById<TextView>(R.id.textView7)
        val secondTxt = view.findViewById<TextView>(R.id.textView8)
        val thirdTxt = view.findViewById<TextView>(R.id.textView9)
        val fourthTxt = view.findViewById<TextView>(R.id.textView10)
        val fifthTxt = view.findViewById<TextView>(R.id.textView11)
        val sixTxt = view.findViewById<TextView>(R.id.textView12)
        val seventhTxt = view.findViewById<TextView>(R.id.textView13)
        val eightTxt = view.findViewById<TextView>(R.id.textView14)
        val nineTxt = view.findViewById<TextView>(R.id.textView15)
        val tenTxt = view.findViewById<TextView>(R.id.textView16)
        val eleTxt = view.findViewById<TextView>(R.id.textView17)
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
        holder.Heading.text = jobResponse?.get(position)?.company_name
        holder.secondTxt.text = jobResponse?.get(position)?.designation
        holder.thirdTxt.text = jobResponse?.get(position)?.description
        holder.fourthTxt.text = jobResponse?.get(position)?.province
        holder.fifthTxt.text = jobResponse?.get(position)?.city
        holder.sixTxt.text = jobResponse?.get(position)?.designation
        holder.seventhTxt.text = jobResponse?.get(position)?.job_type
        holder.eightTxt.text = jobResponse?.get(position)?.provider_name
        holder.nineTxt.text = jobResponse?.get(position)?.requirements
       // holder.tenTxt.text = jobResponse?.get(position)?.provider.toString()
        holder.eleTxt.text = jobResponse?.get(position)?.minimum_wage.toString()
    }

    private var onItemClickListener: ((JobListDataClass) -> Unit)? = null

    fun setOnClickListner(listener: (JobListDataClass) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return jobResponse?.size!!
    }

}