package com.shinto.helpintern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinto.helpintern.databinding.FragmentJobFragmentBinding
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding

lateinit var bindingJ: FragmentJobFragmentBinding
lateinit var navController:NavController

class job_fragment : Fragment() {

    lateinit var adapterclass: HelpInternrecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingJ = FragmentJobFragmentBinding.inflate(inflater, container, false)
        navController = findNavController()

        //inflater.inflate(R.layout.fragment_job_fragment, container, false)

        bindingJ.apply {
            jobRecycler.apply {
                adapter = adapterclass
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

            }
        }


        return bindingJ.root
    }

}