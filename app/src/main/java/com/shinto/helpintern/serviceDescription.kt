package com.shinto.helpintern

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
import com.shinto.helpintern.databinding.ServiceDescriptionBinding


class serviceDescription : Fragment() {
    private lateinit var viewModel: ServiceViewModel
    private lateinit var binding: ServiceDescriptionBinding
    private val args: serviceDescriptionArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = ServiceDescriptionBinding.inflate(inflater, container, false)
        val serviceDiscriptionFactory = ServiceDescriptionFactory(args.serviceDescriptionArgs)
        viewModel =
            ViewModelProvider(this, serviceDiscriptionFactory).get(ServiceViewModel::class.java)

        viewModel.nameService.observe(viewLifecycleOwner, Observer {
            binding.serviceDiscription.text = it
        })

        return binding.root
    }

}