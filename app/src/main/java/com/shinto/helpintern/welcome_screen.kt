package com.shinto.helpintern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding
import com.shinto.helpintern.databinding.FragmentWelcomeScreenBinding

class welcome_screen : Fragment() {
    private var _binding: FragmentWelcomeScreenBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val binding get() = _binding!!
// This property is only valid between onCreateView and
// onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        // return inflater.inflate(R.layout.fragment_welcome_screen, container, false)
        binding.btnSignIn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcome_screen_to_singin_fragment)
            //  Navigation.createNavigateOnClickListener(R.id.action_welcome_screen_to_singin_fragment)
        }
        val view = binding.root
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}