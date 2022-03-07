package com.shinto.helpintern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.shinto.helpintern.databinding.FragmentHomeScreenBinding

class Home_screen : Fragment() {

    private var _binding:FragmentHomeScreenBinding?= null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)

        binding?.cardJobPortal?.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.job_fragment)
        }
        return binding?.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
       _binding = null
    }
}