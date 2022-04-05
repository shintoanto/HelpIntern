package com.shinto.helpintern.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.shinto.helpintern.Model.ServiceDescriptionFactory
import com.shinto.helpintern.Model.ServiceViewModel
import com.shinto.helpintern.R
import com.shinto.helpintern.databinding.ServiceDescriptionBinding


class Service_discription_fragment : Fragment() {

    private lateinit var binding: ServiceDescriptionBinding
    private lateinit var serviceViewModel: ServiceViewModel
    val arags: Service_discription_fragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ServiceDescriptionBinding.inflate(inflater, container, false)


        val serviceFactory = ServiceDescriptionFactory(arags.serviceArg)
        serviceViewModel = ViewModelProvider(this, serviceFactory).get(ServiceViewModel::class.java)

        serviceViewModel.City.observe(viewLifecycleOwner, Observer {
            binding.textView10
        })

        return binding.root
    }

}