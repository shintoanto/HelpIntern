package com.shinto.helpintern

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.offline.ChatDomain

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val client = ChatClient.Builder(getString(R.string.api_key), this)
            .logLevel(ChatLogLevel.ALL).build()
        ChatDomain.Builder(client, this).build()
    }
}