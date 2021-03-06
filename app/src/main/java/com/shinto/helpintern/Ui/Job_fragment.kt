package com.shinto.helpintern.Ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.Resource
import com.shinto.helpintern.databinding.FragmentJobFragmentBinding

class Job_fragment : Fragment() {
    lateinit var navController: NavController
    lateinit var joblistAdapter: HelpInternrecycler
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentJobFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJobFragmentBinding.inflate(inflater, container, false)
        val repository = Repository()
        navController = findNavController()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.joblistResponse.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { jobResponse ->
                        Log.d("Res", "Resource is success$jobResponse")
                        joblistAdapter.differ.submitList(jobResponse)
                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Log.d("Res", it.toString())
                    }
                }
                is Resource.Loading -> {
                    Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                }
            }
        })
        job_list_adapter()
        joblistAdapter.setOnClickListner {
            Log.d("Res", "adapter onclick is working")
            navigate(it)
        }


//        val names = arrayOf("android", "gtech", "samsunt")
//        val adapter: ArrayAdapter<String> = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, names
//        )
//        _binding.serList.adapter = adapter
//        _binding.servSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                _binding.servSearch.clearFocus()
//                if (names.contains(p0)) {
//                    adapter.filter.filter(p0)
//                } else {
//                    Toast.makeText(context, "NOt found", Toast.LENGTH_LONG).show()
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                adapter.filter.filter(p0)
//                return false
//            }
//
//        })


        return binding.root
    }

    private fun navigate(it: JobListDataClass) {
        Log.d("Res", "jljljjljjklkl")
        val action: NavDirections =
            Job_fragmentDirections.actionJobFragmentToJobsDescriptionFragment(it)
        navController.navigate(action)
    }

    private fun showProgressBar() {
        binding.progBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progBar.visibility = View.INVISIBLE
    }

    private fun job_list_adapter() {
        // joblistAdapter = HelpInternrecycler(jobResponse, context, navController)
        joblistAdapter = HelpInternrecycler()
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
//        binding = null!!
//    }

}
