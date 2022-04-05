package com.shinto.helpintern.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinto.helpintern.R
import com.shinto.helpintern.databinding.FragmentAccomodationDescriptionBinding
import com.shinto.helpintern.databinding.FragmentAccomodationFragmentBinding
import java.util.zip.Inflater

class accomodation_description : Fragment() {
    private lateinit var binding: FragmentAccomodationDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccomodationDescriptionBinding.inflate(inflater, container, false)



        return binding.root
    }


}