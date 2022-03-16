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
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinto.helpintern.Data.Get.JobListDataClass
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
                showProgressBar()
                response.body().let { jobResponse ->
                    hideProgressBar()
                    //joblistAdapter = HelpInternrecycler(jobResponse,context)
                    // joblistAdapter.differ.submitList(jobResponse)
                    job_list_adapter(jobResponse, context,navController)
                }
            }else{
                showProgressBar()
            }

        })
//        joblistAdapter.setItemClickListner {
//
//        }


        return binding.root
    }
//    private fun navigate(it:JobListDataClass){
//        val action:NavDirections = Job_fragmentDi.action_job_fragment_to_jobs_description_fragment
//    }

    private fun showProgressBar() {
        _binding.progBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        _binding.progBar.visibility = View.INVISIBLE
    }

    private fun job_list_adapter(
        jobResponse: List<JobListDataClass>?,
        context: Context?,
        navController: NavController
    ) {
        joblistAdapter = HelpInternrecycler(jobResponse, context,navController)
        binding.jobRecycler.adapter = joblistAdapter
        binding.jobRecycler.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(13)
            adapter = joblistAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}
