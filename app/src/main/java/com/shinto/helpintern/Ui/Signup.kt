package com.shinto.helpintern.Ui

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.shinto.helpintern.Data.Post.UserRegistration
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.databinding.FragmentSignupBinding
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding

class signup : Fragment() {
    lateinit var _binding: FragmentSignupBinding
    private val binding get() = _binding
    private lateinit var viewModel: MainViewModel
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout {
        // Inflate the layout for this fragment
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
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
                "$email",
                "$firstName",
                "$secondName",
                "$password",
                "$phoneNumber",
                "$",
                "$rePassword",
                "$userName"
            )
        )

        binding.imgSignIn.setOnClickListener {
            signUp()
        }
        emailFocusChangeListner()
        passwordFocusChangeListner()
        //  usernameFocusChangeListner()

        return binding.root
        // inflater.inflate(R.layout.fragment_signup, container, false)
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
                Log.d("Res", "Not working"+response.message())
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