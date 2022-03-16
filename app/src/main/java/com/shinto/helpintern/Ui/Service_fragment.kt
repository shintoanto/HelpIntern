package com.shinto.helpintern.Ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinto.helpintern.Adapter.ServiceAdapter
import com.shinto.helpintern.Data.Get.ServiceListItem
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.Resource
import com.shinto.helpintern.databinding.ServiceFragmentBinding

class Service_fragment : Fragment() {

    lateinit var navController: NavController
    lateinit var serviceAdapter: ServiceAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var _binding: ServiceFragmentBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = ServiceFragmentBinding.inflate(inflater, container, false)

        val repository = Repository()
        navController = findNavController()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.userList()
        viewModel.serviceResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                hideProgressBar()
                response.body().let { serviceResponse ->
                    //joblistAdapter = HelpInternrecycler(jobResponse,context)
                    // joblistAdapter.differ.submitList(jobResponse)
                    service_list_adapter(serviceResponse, context)
                }
            } else {
                showProgressBar()
            }
        })

        return binding.root
    }

    private fun showProgressBar() {
        _binding.progBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        _binding.progBar.visibility = View.INVISIBLE
    }

    private fun service_list_adapter(serviceResponse: List<ServiceListItem>?, context: Context?) {
        serviceAdapter = ServiceAdapter(serviceResponse, context)
        binding.serviceRecycler.adapter = serviceAdapter
        binding.serviceRecycler.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(13)
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

}