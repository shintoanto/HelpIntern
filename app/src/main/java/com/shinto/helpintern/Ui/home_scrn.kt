package com.shinto.helpintern.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.shinto.helpintern.R
import com.shinto.helpintern.databinding.FragmentHomeScrnBinding
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding

class home_scrn : Fragment() {

    private var _binding: FragmentHomeScrnBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScrnBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding?.jobBtn?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.job_fragment)
        }
        val view = binding?.root
        return view!!// inflater.inflate(R.layout.fragment_home_scrn, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}