package com.shinto.helpintern.Ui

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.Repository.Repository
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
        navController = findNavController()
        val viewModelFactory = ViewModelFactory(repository)

        val firstName = binding.firstEditxt.text
        val secondName = binding.lastEdtTxt.text
        val userName = binding.usrEdtext.text
        val email = binding.emailEdtTxt.text
        val phoneNumber = binding.phNumEdtTxt.text
        val password = binding.passwordEditext
        val rePassword = binding.rePasswordEditext.text

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.registration(
            UserRegistration(
                email = "shintosa@outlook.com",
                first_name = "shintaos",
                last_name = "shifaas",
                password = "0000a0",
                phone_number = "0000001200",
                repassword = "0000a0",
                username = "antosss"
            )
        )
        viewModel.registerResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Res", "messag body" + response.body().toString())
                Log.d("Res", "response code :" + response.code().toString())
                Log.d("Res", "response message" + response.message())
            } else {
                Log.d("Res", "Not working" + response.code().toString())
            }
        })

        binding.imgSignIn.setOnClickListener {
            signUp()
        }

        emailFocusChangeListner()
        passwordFocusChangeListner()
        latName()
        firsName()
        phoneNumberChangeListner()
        binding.registerImageBtn.setOnClickListener {
            regristerProfilePictureFun()
        }

        return binding.root
    }

    private fun regristerProfilePictureFun() {
        val registerImage = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.registerImg.setImageURI(it!!)
            }
        )
        registerImage.launch("image/*")
    }


    private fun name() {
        _binding.firstEditxt.setOnClickListener {

        }
    }


    private fun userName(): CharSequence? {
        val userName = _binding.usrEdtext.text.toString()
        if (userName.isEmpty()) {
            _binding.usrContainer.error = "Enter your user name"
        }
        return "Enter user  name"
    }

    private fun firsName() {
        _binding.usrEdtext.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                _binding.usrContainer.helperText = userName()
            }
        }
    }

    private fun firtName() {
        val userName = _binding.firstEditxt.text.toString()
        if (userName.isEmpty()) {
            _binding.usrContainer.error = "Enter your first name"
        }
    }

    private fun latName() {
        _binding.lastEdtTxt.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                _binding.lastNameContainer.helperText = lasName()
            }
        }
    }

    private fun lasName(): CharSequence? {
        val userName = _binding.lastEdtTxt.text.toString()
        if (userName.isEmpty()) {
            _binding.lastNameContainer.error = "Enter your first name"
        }
        return "Enter your last name"
    }

    private fun phoneNumberChangeListner() {
        _binding.phNumEdtTxt.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                _binding.phNumContainer.helperText = phoneNumber()
            }
        }
    }

    private fun phoneNumber(): CharSequence? {
        val phone = _binding.phNumEdtTxt.text.toString()
        if (phone.matches(".*[0-9]".toRegex())) {
            _binding.phNumContainer.error = "Enter your valid phone number"
        }
        if (phone.isEmpty()) {
            _binding.phNumContainer.error = "This field is required"
        }
        if (phone.length != 10) {
            _binding.phNumContainer.error = "Enter 10 fields"
        }
        return null
    }

    private fun emailFocusChangeListner() {
        _binding.emailEdtTxt.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                _binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = _binding.emailEdtTxt.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
        return null
    }

    private fun passwordFocusChangeListner() {
        _binding.passwordEditext.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                _binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = _binding.passwordEditext.text.toString()
        if (passwordText.length < 8) {
            return "Minimum 8 character"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Must contain 1 upper case charectore"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Must contain 1 small case charectore"
        }
        if (!passwordText.matches(".*[@#\$%^&+=].*".toRegex())) {
            return "Must contain 1 lower-case Character"
        }
        return null
    }

    private fun signUp() {
        viewModel.registerResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Res", response.body().toString())
                Log.d("Res", response.code().toString())
                Log.d("Res", response.message())
            } else {
                //   Toast.makeText(context, response.code(), Toast.LENGTH_LONG).show()
                Log.d("Res", "Not working" + response.message())
            }
        })
    }

//    private fun usernameFocusChangeListner() {
//        _binding?.userEditText?.setOnFocusChangeListener { _, focused ->
//            if (!focused) {
//                _binding!!.userContainer.helperText = validUser()
//            }
//        }
//    }

//    private fun validUser(): String? {
//        val emailText = _binding?.userEditText?.text.toString()
//        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
//            return "Invalid user Address"
//        }
//        return null
//    }

}