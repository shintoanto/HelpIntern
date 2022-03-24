package com.shinto.helpintern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.shinto.helpintern.databinding.ChatLoginFragmentBinding

class ChatLogin : Fragment() {

    private var _binding: ChatLoginFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ChatLoginFragmentBinding.inflate(inflater, container, false)
        binding?.imgSignIn?.setOnClickListener {
            authenticateTheUser()
        }
        return binding?.root!!
    }

    private fun authenticateTheUser() {
        val firstName = binding?.emailEditext?.text.toString()
        val username = binding?.passwordEditext?.text.toString()
        if (validateInput(firstName, binding?.emailContainer!!) &&
            validateInput(username, binding?.passwordContainer!!)
        ) {
            val chatUser = ChatUser(firstName, username)
            val action = ChatLoginDirections.actionChatLoginToChannelFragment(chatUser)
            findNavController().navigate(action)
        }
    }

    private fun validateInput(inputText: String, textInputLayout: TextInputLayout): Boolean {
        return if (inputText.length <= 3) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = "* Minimum 4 Characters Allowed"
            false
        } else {
            textInputLayout.isErrorEnabled = false
            textInputLayout.error = null
            true
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}