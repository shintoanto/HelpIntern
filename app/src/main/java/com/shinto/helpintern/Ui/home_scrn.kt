package com.shinto.helpintern.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
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
//        // Inflate the layout for this fragment

        binding?.accomodationCard?.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(home_scrnDirections.actionHomeScrnToAccomodationFragment())
        }

        binding?.cardJobPortal?.setOnClickListener { view: View ->
            view.findNavController().navigate(home_scrnDirections.actionHomeScrnToJobFragment())
        }

        binding?.cardView2?.setOnClickListener { view: View ->
            view.findNavController().navigate(home_scrnDirections.actionHomeScrnToServiceFragment())
        }


        return binding?.root!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}