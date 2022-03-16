package com.shinto.helpintern.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.R
import com.shinto.helpintern.databinding.FragmentJobsDescriptionFragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [jobs_description_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class jobs_description_fragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    lateinit var _binding: FragmentJobsDescriptionFragmentBinding
    private val binding get() = _binding
  //  val args: by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jobs_description_fragment, container, false)
    }


}