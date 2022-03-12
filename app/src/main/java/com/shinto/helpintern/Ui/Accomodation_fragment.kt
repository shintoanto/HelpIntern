package com.shinto.helpintern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.databinding.AccomodationCardViewBinding
import com.shinto.helpintern.databinding.FragmentAccomodationFragmentBinding
import java.security.acl.Owner

class accomodation_fragment : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var accomodationAdapter: HelpInternrecycler
    lateinit var _binding: FragmentAccomodationFragmentBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccomodationFragmentBinding.inflate(inflater, container, false)

        val repository = Repository()
        viewModel.accomodationList()


        viewModel.accomodationResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { accomodationResponse ->

                }
            }
        })

        // Inflate the layout for this fragment
        val view = binding.root
        return view
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}