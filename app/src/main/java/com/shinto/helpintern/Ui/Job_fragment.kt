package com.shinto.helpintern.Ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinto.helpintern.Data.JobListDataClass
import com.shinto.helpintern.HelpInternrecycler
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.databinding.FragmentJobFragmentBinding

class Job_fragment : Fragment() {
    lateinit var navController: NavController
    lateinit var joblistAdapter: HelpInternrecycler
    private lateinit var viewModel: MainViewModel
    lateinit var _binding: FragmentJobFragmentBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobFragmentBinding.inflate(inflater, container, false)
        val repository = Repository()
        navController = findNavController()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getJobList()
        viewModel.joblistResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body().let { jobResponse ->
                    //joblistAdapter = HelpInternrecycler(jobResponse,context)
                    //joblistAdapter.differ.submitList(jobResponse)
                    job_list_adapter(jobResponse, context)
                }
            }
        })

        val view = binding.root
        return view
    }

    private fun job_list_adapter(jobResponse: List<JobListDataClass>?, context: Context?) {
        joblistAdapter = HelpInternrecycler(jobResponse, context)
        binding.jobRecycler.setHasFixedSize(true)
        binding.jobRecycler.setItemViewCacheSize(13)
        binding.jobRecycler.adapter = joblistAdapter
        binding.apply {
            jobRecycler.apply {
                adapter = joblistAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}
