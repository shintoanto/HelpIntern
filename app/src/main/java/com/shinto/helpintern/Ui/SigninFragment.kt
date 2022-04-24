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
import com.shinto.helpintern.Data.Post.UserLogin
import com.shinto.helpintern.MainViewModel
import com.shinto.helpintern.Model.ViewModelFactory
import com.shinto.helpintern.R
import com.shinto.helpintern.Repository.Repository
import com.shinto.helpintern.Resource
import com.shinto.helpintern.databinding.FragmentSinginFragmentBinding

class SigninFragment : Fragment() {

    // private lateinit var auth: FirebaseAuth
    lateinit var navController: NavController
    private var _binding: FragmentSinginFragmentBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        viewModel.logIn.observe(viewLifecycleOwner, Observer { response ->
            Log.d("Res","viewmodellogin")
            when (response) {
                is Resource.Success -> {
                    Log.i("refresh", response.data!!.accessToken)
//                    val refreshToken = response.data.refreshToken
//                    val accessToken = response.data.accessToken
                    viewModel.progressBar(false)
                    //   viewModel.mainViewVisibility(true)
                    response.data.let { message ->
                        Log.i("LogInResponse", message.toString())
                        //   toast("Log In successful")
                    }
                    val action = SigninFragmentDirections.actionSinginFragmentToHomeScrn()
                    navController.navigate(action)
                    viewModel.saveUserDetails(response.data.refreshToken)
//                    val action = Singin.actionLogInFragmentToBottomBarActivity()
//                    navController.navigate(action)
                }
                is Resource.Error -> {
                    viewModel.progressBar(false)
                    //    viewModel.mainViewVisibility(true)
                    //  toast()
                }
                is Resource.Loading -> {
                    viewModel.progressBar(true)
                    //   viewModel.mainViewVisibility(false)
                    Log.i("LogInResponse", "Loading")
                }
            }
        })


        viewModel.logInEmain.observe(viewLifecycleOwner, Observer {
            Log.d("Res", "loginemain")
            if (!Patterns.EMAIL_ADDRESS.matcher(it).matches()) {
                binding?.emailEditext?.error = "Invalid Email Id"
                return@Observer
            }
            if (it.isNullOrEmpty()) {
                binding?.emailEditext?.error = "Field is required"
                return@Observer
            }
            viewModel.isEmailValidLogin = true
        })

        viewModel.passwordLogIN.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) {
                binding?.passwordEditext?.error = "Field is required"
                return@Observer
            }
            viewModel.isPasswordValied = true
            Log.i("password", viewModel.password.value.toString())
        })

        binding?.imgSignIn?.setOnClickListener {
            Log.d("Res", "sign in working")
            //Log.d("Res",s.toString())
            Log.d("Res", viewModel.isEmailValidLogin.toString())
            Log.d("Res", viewModel.isPasswordValied.toString())
            if (viewModel.isEmailValidLogin && viewModel.isPasswordValied) {
                val logInDetails = UserLogin(viewModel.email.value, viewModel.password.value)
                viewModel.logInData(logInDetails)
            } else {
                Log.d("Res", "login not work")
                Toast.makeText(context, "Login not success", Toast.LENGTH_LONG).show()
            }
        }
        return binding?.root!!
    }
}