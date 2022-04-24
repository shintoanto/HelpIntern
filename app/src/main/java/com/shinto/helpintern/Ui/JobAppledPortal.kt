package com.shinto.helpintern.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shinto.helpintern.R
import com.shinto.helpintern.databinding.JobAppliedPortalBinding

class JobAppledPortal : Fragment() {
    private var _binding: JobAppliedPortalBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = JobAppliedPortalBinding.inflate(inflater, container, false)


        return binding?.root
    }
}