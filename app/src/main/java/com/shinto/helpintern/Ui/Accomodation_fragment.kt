package com.shinto.helpintern

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shinto.helpintern.Adapter.AccomodationAdapter
import com.shinto.helpintern.Data.Get.AccomodationDataClassItem
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.databinding.FragmentAccomodationFragmentBinding


class accomodation_fragment : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var accomodationAdapter: AccomodationAdapter
    private lateinit var _binding: FragmentAccomodationFragmentBinding
    private val binding get() = _binding
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccomodationFragmentBinding.inflate(inflater, container, false)

        val repository = Repository()
        navController = findNavController()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.accomodationResponse.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    viewModel.mainVisibility(true)
                    response.data?.let { accomodationResponse ->
                        accomodationAdapter.differ.submitList(accomodationResponse)
                    }

                }
                is Resource.Error -> {
                    response.message?.let {
                        Log.d("Res", it.toString())
                    }
                }
                is Resource.Loading ->{
                   showProgressBar()
                }
            }
        })

        accomodationListAdapterSet(context)


//        val names = arrayOf("android", "gtech", "samsunt")
//        val adapter: ArrayAdapter<String> = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, names
//        )
//        _binding.serList.adapter = adapter
//        _binding.servSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                _binding.servSearch.clearFocus()
//                if (names.contains(p0)) {
//                    adapter.filter.filter(p0)
//                } else {
//                    Toast.makeText(context, "NOt found", Toast.LENGTH_LONG).show()
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                adapter.filter.filter(p0)
//                return false
//            }
//
//        })

        // Inflate the layout for this fragment
        return binding.root
    }
//    private fun navigation(it:AccomodationDataClassItem){
//        val action:NavDirections = Acco
//    }

    private fun showProgressBar() {
        _binding.progBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        _binding.progBar.visibility = View.INVISIBLE
    }

    private fun accomodationListAdapterSet(
        context: Context?,
//        accomodationResponse: List<AccomodationDataClassItem>,
    ) {
        accomodationAdapter = AccomodationAdapter(context)
        binding.accomodRecycler.adapter = accomodationAdapter
        binding.accomodRecycler.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(13)
            adapter = accomodationAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null!!
//    }
}