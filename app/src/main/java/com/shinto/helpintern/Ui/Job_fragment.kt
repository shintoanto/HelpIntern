package com.shinto.helpintern.Ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinto.helpintern.HelpInternrecycler
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.ViewModelFactory
import com.shinto.helpintern.databinding.FragmentJobFragmentBinding

class Job_fragment : Fragment() {
    lateinit var navController: NavController
    lateinit var joblistAdapter: HelpInternrecycler
    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentJobFragmentBinding? = null
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
        navController = findNavController()
        viewModel.joblistResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body().let { jobResponse ->
                    Log.d("Res", jobResponse.toString())
                }
            }
        })
        job_list_adapter()
        val view = binding?.root
        return view!!
    }
    private fun job_list_adapter() {
        joblistAdapter = HelpInternrecycler()
        binding?.apply {
            jobRecycler.apply {
                adapter = joblistAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
