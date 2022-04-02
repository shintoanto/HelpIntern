package com.shinto.helpintern.Ui

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.Resource
import com.shinto.helpintern.databinding.FragmentSignupBinding

class signup : Fragment() {

    lateinit var _binding: FragmentSignupBinding
    private val binding get() = _binding
    private lateinit var viewModel: MainViewModel
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignupBinding.inflate(inflater, container, false)

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        binding.users = viewModel
        navController = findNavController()




//        val firstName = binding.firstEditxt.text.toString()
//        val secondName = binding.lastEdtTxt.text.toString()
//        val userName = binding.usrEdtext.text.toString()
//        val email = binding.emailEdtTxt.text.toString()
//        val phoneNumber = binding.phNumEdtTxt.text.toString()
//        val password = binding.passwordEditext.toString()
//        val rePassword = binding.rePasswordEditext.text.toString()


        Log.d("Res", "signup fragment")
//        binding.imgSignIn.setOnClickListener {
//            signUp()
//        }

//        emailFocusChangeListner()
//        passwordFocusChangeListner()
//        latName()
//        firsName()
//        phoneNumberChangeListner()

//        binding.registerImageBtn.setOnClickListener {
//            regristerProfilePictureFun()
//        }
        viewModel.email.observe(viewLifecycleOwner, Observer {
            Log.d("Res", "susnnnn")
            if (!Patterns.EMAIL_ADDRESS.matcher(it).matches()) {
                binding.emailEdtTxt.error = "Enter your valid email"
                return@Observer
            }
            if (it.isNullOrEmpty()) {
                binding.emailEdtTxt.error = "Field is required"
                return@Observer
            }
            viewModel.isEmailValid = true
        })
        viewModel.first_name.observe(viewLifecycleOwner, Observer {
            Log.d("Res", "imgSigniin")
            if (it.isNullOrEmpty()) {
                binding.firstEditxt.error = "This field is required"
                return@Observer
            }

            if (it.length < 4) {
                binding.firstEditxt.error = "Minimum 4 characters"
                return@Observer
            }
            viewModel.isFirstName = true
        })
        viewModel.last_name.observe(viewLifecycleOwner, Observer {
            Log.d("Res", "imgSigniin")
            if (it.isNullOrEmpty()) {
                binding.lastEdtTxt.error = "This field is required"
                return@Observer
            }

            if (it.length < 2) {
                binding.lastEdtTxt.error = "Minimum 2 characters"
                return@Observer
            }
            viewModel.isLastName = true
        })
        viewModel.username.observe(viewLifecycleOwner, Observer {
            Log.d("Res", "imgSigniin")
            if (it.isNullOrEmpty()) {
                binding.usrEdtext.error = "This field is required"
                return@Observer
            }

            if (it.length < 3) {
                binding.usrEdtext.error = "Minimum 3 characters"
                return@Observer
            }
            viewModel.isUserName = true
        })
        viewModel.phone_number.observe(viewLifecycleOwner, Observer {
            Log.d("Res", "imgSigniin")
            if (!it.matches(".*[0-9]".toRegex())) {
                binding.phNumEdtTxt.error = "Enter your valid phone number"
                return@Observer

            }
            if (it.isNullOrEmpty()) {
                binding.phNumEdtTxt.error = "This field is required"
                return@Observer
            }
            if (it.length != 10) {
                binding.phNumEdtTxt.error = "Must be 10 Digits"
                return@Observer
            }
            viewModel.isPhoneValid = true

        })
        viewModel.password.observe(viewLifecycleOwner, Observer {
            Log.d("Res", "imgSigniin")
            if (it.length < 5) {
                binding.passwordEditext.error = "minimum 5 characters"
                return@Observer
            }
            if (it.isNullOrEmpty()) {
                binding.passwordEditext.error = "Field is required"
                return@Observer
            }
            viewModel.isPassword = true
        })
        viewModel.repassword.observe(viewLifecycleOwner, Observer {
            Log.d("Res", "imgSigniin")
            if (it.length < 5) {
                binding.rePasswordEditext.error = "minimum 5 characters"
                return@Observer
            }
            if (it.isNullOrEmpty()) {
                binding.rePasswordEditext.error = "Field is required"
                return@Observer
            }
            viewModel.isRepassword = true
        })
        viewModel.signUp.observe(viewLifecycleOwner, Observer { responce ->
            when(responce){
                is Resource.Success ->{
                    hideProgressBar()
                    responce.data?.let { res ->
                        Log.i("ServerResponse", res)
                        Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
                    }


                }
                is Resource.Loading ->{
                    showProgressBar()
                }
            }
        })

        binding.imgSignIn.setOnClickListener {
            Log.d("Res", "imgSigniinBTNNn")
            if (viewModel.isEmailValid && viewModel.isPassword && viewModel.isRepassword && viewModel.isUserName) {
                Log.d("Res", "imgSigniin")
                val reg =
                    UserRegistration(
                        viewModel.email.value!!,
                        viewModel.first_name.value!!,
                        viewModel.last_name.value!!,
                        viewModel.password.value!!,
                        viewModel.repassword.value!!,
                        viewModel.username.value!!,
                        viewModel.phone_number.value!!
                    )
                viewModel.signUpRegistrationData(reg)
                Log.d("Res", reg.toString())
            }
        }

        Log.d("Res", "signup fragment2 ")
        return binding.root
    }
    private fun showProgressBar() {
        binding.progBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progBar.visibility = View.INVISIBLE
    }

//    private fun regristerProfilePictureFun() {
//        val registerImage = registerForActivityResult(
//            ActivityResultContracts.GetContent(),
//            ActivityResultCallback {
//                binding.registerImg.setImageURI(it!!)
//            }
//        )
//        registerImage.launch("image/*")
//    }


}