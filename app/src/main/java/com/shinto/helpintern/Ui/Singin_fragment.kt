package com.shinto.helpintern.Ui

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.shinto.helpintern.Data.Post.UserLogin
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.R
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding


class singin_fragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentSinginFragmentBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: MainViewModel

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize Firebase Auth
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSinginFragmentBinding.inflate(inflater, container, false)
        binding?.singinBtn?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcome_screen_to_singin_fragment)
        }
        binding?.imgSignIn?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.home_scrn)
        }
        binding?.singUpBtn?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.signup)
        }
        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.userLoginViewModel(
            UserLogin(
                email = "shintopa@outlook.com",
                password = "9895137135"
            )
        )
        viewModel.userLoginResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Res", response.body().toString())
                Log.d("Res", response.code().toString())
                Log.d("Res", response.message())
            } else {
                // Toast.makeText(context, response.code(), Toast.LENGTH_LONG).show()
                Log.d("Res", "Not working" + response.code().toString())
            }
        })

        emailFocusChangeListner()
        passwordFocusChangeListner()



        return binding?.root!!
    }

    private fun emailFocusChangeListner() {
        binding?.emailEditext?.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding?.emailContainer?.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding?.emailEditext?.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
        return null
    }

    private fun passwordFocusChangeListner() {
        binding?.passwordEditext?.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding?.passwordContainer?.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding?.passwordEditext?.text.toString()
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

//        private fun usernameFocusChangeListner() {
//        _binding?.emailEditext?.setOnFocusChangeListener { _, focused ->
//            if (!focused) {
//                _binding!!.emailContainer.helperText = validUser()
//            }
//        }
//    }
//
//    private fun validUser(): String? {
//        val emailText = _binding?.passwordEditext?.text.toString()
//        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
//            return "Invalid user Address"
//        }
//        return null
//    }

    fun reload() {
        Log.d("res", "hail")
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}