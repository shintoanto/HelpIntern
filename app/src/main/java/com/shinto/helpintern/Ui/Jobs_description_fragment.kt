package com.shinto.helpintern.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.R
import com.shinto.helpintern.databinding.FragmentJobsDescriptionFragmentBinding

class jobs_description_fragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    lateinit var _binding: FragmentJobsDescriptionFragmentBinding
    private val binding get() = _binding
  // val args: by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jobs_description_fragment, container, false)
    }


}