package com.shinto.helpintern.Ui

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.shinto.helpintern.Data.Post.UserLogin
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.R
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.Resource
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding


class singin_fragment : Fragment() {

    // private lateinit var auth: FirebaseAuth
    lateinit var navController: NavController
    private var _binding: FragmentSinginFragmentBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: MainViewModel

//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            reload()
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize Firebase Auth
        //  auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSinginFragmentBinding.inflate(inflater, container, false)

        val repository = Repository()
        navController = findNavController()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding?.singinBtn?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcome_screen_to_singin_fragment)
        }
        binding?.imgSignIn?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.home_scrn)
        }
        binding?.singUpBtn?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.signup)
        }


//        viewModel.userLoginResponse.observe(viewLifecycleOwner, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Res", response.body().toString())
//                Log.d("Res", response.code().toString())
//                Log.d("Res", response.message())
//            } else {
//                // Toast.makeText(context, response.code(), Toast.LENGTH_LONG).show()
//                Log.d("Res", "Not working" + response.code().toString())
//            }
//        })

        viewModel.logIn.observe(viewLifecycleOwner, Observer { loginResponse ->

            when (loginResponse) {
                is Resource.Success -> {
                    viewModel.saveUserDetails(loginResponse.data?.refreshToken!!)
                    // val action =
                }
            }
        })

        viewModel.logInEmain.observe(viewLifecycleOwner, Observer { emailResponse ->
            if (!Patterns.EMAIL_ADDRESS.matcher(emailResponse).matches()) {
                binding?.emailEditext?.error = "Invalid Email Id"
                return@Observer
            }
            if (emailResponse.isNullOrEmpty()) {
                binding?.emailEditext?.error = "Field is required"
                return@Observer
            }
            viewModel.isEmailValid = true
        })

        viewModel.passwordLogIN.observe(viewLifecycleOwner, Observer { passwordResponse ->
            if (passwordResponse.isNullOrEmpty()) {
                binding?.passwordEditext?.error = "Field is required"
                return@Observer
            }
            viewModel.isPasswordValied = true
            Log.i("password", viewModel.password.value.toString())
        })

//        binding?.imgSignIn?.setOnClickListener {
//            Log.d("Res", "sign in working")
//            //Log.d("Res",s.toString())
//            if (viewModel.isEmailValid && viewModel.isPassword) {
//                val logInDetails = UserLogin(viewModel.email.value, viewModel.password.value)
//                viewModel.logInData(logInDetails)
//            } else {
//                Log.d("Res", "login not work")
//                Toast.makeText(context,"Login not success",Toast.LENGTH_LONG).show()
//            }
//        }


        return binding?.root!!
    }


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

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}