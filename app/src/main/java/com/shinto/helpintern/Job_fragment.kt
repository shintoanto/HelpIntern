package com.shinto.helpintern

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinto.helpintern.databinding.FragmentJobFragmentBinding

@SuppressLint("StaticFieldLeak")
lateinit var navController: NavController

class job_fragment : Fragment() {

    lateinit var adapterclass: HelpInternrecycler
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: FragmentJobFragmentBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get()= _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentJobFragmentBinding.inflate(inflater, container, false)
        navController = findNavController()
        viewModel.getJobList()
        viewModel.joblistResponse.observe(viewLifecycleOwner, { response ->
            Log.d("Res", response.city)
        })
        binding?.apply {
            jobRecycler.apply {
                adapter = adapterclass
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            }
        }

        val view = binding?.root
        return view!!
    }

}