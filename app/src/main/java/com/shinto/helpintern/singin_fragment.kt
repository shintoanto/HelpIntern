package com.shinto.helpintern

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding

lateinit var binding: FragmentSinginFragmentBinding

class singin_fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSinginFragmentBinding.inflate(inflater, container, false)
        binding.singinBtn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcome_screen_to_singin_fragment)
        }
        binding.imgSignIn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.home_screen)
        }
        emailFocusChangeListner()
        passwordFocusChangeListner()
        val em = "shinto@gmail.com"
        var pas = "123"
        val email = binding.emailEditext.text.toString()
        var pass = binding.passwordEditext.text.toString()
        if (email == em && pass == pas) {
            view?.findNavController()?.navigate(R.id.home_screen)
        }else{

        }

        val view = binding.root
        return view
        //inflater.inflate(R.layout.fragment_singin_fragment, container, false)
    }

    private fun emailFocusChangeListner() {
        binding.emailEditext.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validEmail()
            }
        }

    }

    private fun validEmail(): String? {
        val emailText = binding.emailEditext.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
        return null
    }

    private fun passwordFocusChangeListner() {
        binding.passwordEditext.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText = validPassword()
            }
        }
        var pass = binding.passwordEditext.text
    }


    private fun validPassword(): String? {
        val passwordText = binding.passwordEditext.text.toString()
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

    fun onSNACK(view: View) {
        //Snackbar(view)
        val snackbar = Snackbar.make(
            view, "Replace with your own action",
            Snackbar.LENGTH_LONG
        ).setAction("Action", null)
//        snackbar.setActionTextColor(Color.BLUE)
//        val snackbarView = snackbar.view
//        snackbarView.setBackgroundColor(Color.LTGRAY)
//        val textView =
//            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
//        textView.setTextColor(Color.BLUE)
//        textView.textSize = 28f
        snackbar.show()
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}