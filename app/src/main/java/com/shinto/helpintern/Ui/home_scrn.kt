package com.shinto.helpintern.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shinto.helpintern.databinding.FragmentHomeScrnBinding

class home_scrn : Fragment() {

    private var _binding: FragmentHomeScrnBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScrnBinding.inflate(inflater, container, false)
//        // Inflate the layout for this fragment
//        binding?.chatBtn?.setOnClickListener { view: View ->
//            view.findNavController().navigate(home_scrnDirections.actionHomeScrnToChatLogin())
//        }

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

        binding?.cardJobApplied?.setOnClickListener { view: View ->
            view.findNavController().navigate(home_scrnDirections.actionHomeScrnToJobAppledNav())
        }
        binding?.imgAccoulnt?.setOnClickListener{
            it.findNavController().navigate(home_scrnDirections.actionHomeScrnToProfileView())
        }

//        binding?.mapBtn?.setOnClickListener {
//            val intent = Intent(context, MapsActivity::class.java)
//            startActivity(intent)
//        }

        return binding?.root!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}