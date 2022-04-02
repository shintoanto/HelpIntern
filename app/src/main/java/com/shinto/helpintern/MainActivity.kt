package com.shinto.helpintern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import io.getstream.chat.android.client.ChatClient

class MainActivity : AppCompatActivity() {

   // private val client = ChatClient.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment? ?: return

        val navController = host.navController

//        if (navController.currentDestination?.label.toString().contains("login")) {
//            val currentUser = client.getCurrentUser()
//            if (currentUser != null) {
//                val user = ChatUser(currentUser.name, currentUser.id)
//                val action = ChatLoginDirections.actionChatLoginToChannelFragment(user)
//                navController.navigate(action)
//            }
//        }

//        val actionBar = supportActionBar
//
//
//            actionBar?.setBackgroundDrawable(ColorDrawable(Color.BLACK))
//            setupActionBarWithNavController(navController)

    }
}