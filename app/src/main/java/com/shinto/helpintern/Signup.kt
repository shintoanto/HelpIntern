package com.shinto.helpintern

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinto.helpintern.databinding.FragmentSignupBinding
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding

lateinit var _binding: FragmentSignupBinding

class signup : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        emailFocusChangeListner()
        passwordFocusChangeListner()
        usernameFocusChangeListner()

        return _binding.root
        // inflater.inflate(R.layout.fragment_signup, container, false)
    }
    private fun emailFocusChangeListner() {
        _binding.emailEditext.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                _binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = _binding.emailEditext.text.toString()
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

    private fun usernameFocusChangeListner() {
        _binding.userEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                _binding.userContainer.helperText = validUser()
            }
        }
    }

    private fun validUser(): String? {
        val emailText = _binding.userEditText.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid user Address"
        }
        return null
    }

}