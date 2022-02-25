package com.shinto.helpintern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinto.helpintern.databinding.AccomodationCardViewBinding
import com.shinto.helpintern.databinding.FragmentAccomodationFragmentBinding

class accomodation_fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: FragmentAccomodationFragmentBinding? = null
    private val binding get() =_binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccomodationFragmentBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        val view = binding?.root
        return view
    // inflater.inflate(R.layout.fragment_accomodation_fragment, container, false)
    }
}