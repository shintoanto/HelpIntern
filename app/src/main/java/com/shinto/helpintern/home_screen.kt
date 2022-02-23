package com.shinto.helpintern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinto.helpintern.databinding.FragmentHomeScreenBinding

lateinit var bindingH: FragmentHomeScreenBinding

class home_screen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingH = FragmentHomeScreenBinding.inflate(inflater, container, false)

        return bindingH.root
        // inflater.inflate(R.layout.fragment_home_screen, container, false)
    }
}