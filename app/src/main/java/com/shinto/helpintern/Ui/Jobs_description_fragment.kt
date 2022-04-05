package com.shinto.helpintern.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.shinto.helpintern.Model.JobDescriptionDetails
import com.shinto.helpintern.Model.JobDescriptionFactory
import com.shinto.helpintern.databinding.FragmentJobsDescriptionFragmentBinding

class jobs_description_fragment : Fragment() {

    private lateinit var viewModel: JobDescriptionDetails
    lateinit var binding: FragmentJobsDescriptionFragmentBinding
    val args: jobs_description_fragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val detailedFactory = JobDescriptionFactory(args.jobList)
        viewModel = ViewModelProvider(this, detailedFactory).get(JobDescriptionDetails::class.java)

        binding = FragmentJobsDescriptionFragmentBinding.inflate(inflater, container, false)


        viewModel.companyName.observe(viewLifecycleOwner, Observer {
            binding.textView10.text = it
        })
        viewModel.jobPosition.observe(viewLifecycleOwner, Observer {
            binding.textView11.text = it
        })
        viewModel.minimunWage.observe(viewLifecycleOwner, Observer {
            binding.textView12.text = it.toString()
        })
        viewModel.jobDescription.observe(viewLifecycleOwner, Observer {
            binding.jobDesc.text = it.toString()
        })

        return binding.root
    }


}