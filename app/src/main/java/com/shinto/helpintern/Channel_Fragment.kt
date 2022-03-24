package com.shinto.helpintern

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.shinto.helpintern.databinding.FragmentChannelBinding
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.Filters
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.ui.channel.list.adapter.ChannelListItemViewType
import io.getstream.chat.android.ui.channel.list.header.viewmodel.ChannelListHeaderViewModel
import io.getstream.chat.android.ui.channel.list.header.viewmodel.bindView
import io.getstream.chat.android.ui.channel.list.viewmodel.ChannelListViewModel
import io.getstream.chat.android.ui.channel.list.viewmodel.bindView
import io.getstream.chat.android.ui.channel.list.viewmodel.factory.ChannelListViewModelFactory
import java.util.logging.Filter

class Channel_Fragment : Fragment() {

    private val args: Channel_FragmentArgs by navArgs()
    private val binding: FragmentChannelBinding? = null
    private var _binding = binding
    private val client = ChatClient.instance()
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChannelBinding.inflate(inflater, container, false)

        setUpUser()
        setUpChannel()

        return binding?.root!!
    }

    private fun setUpChannel() {
        val filters = Filters.and(
            Filters.eq("type", "messaging"),
            Filters.`in`("members", listOf(client.getCurrentUser()!!.id))
        )

        val viewModelFactory = ChannelListViewModelFactory(
            filters, ChannelListViewModel.DEFAULT_SORT
        )
        val listViewModel: ChannelListViewModel by viewModels { viewModelFactory }
        val listHeaderViewModel: ChannelListHeaderViewModel by viewModels()

        listHeaderViewModel.bindView(binding?.channelListHeaderView!!, viewLifecycleOwner)
        listViewModel.bindView(binding.channelsView, viewLifecycleOwner)
    }

    private fun setUpUser() {
        if (client.getCurrentUser() != null) {
            user = if (args.chatUser.name.contains("Shinto")) {
                User(
                    id = args.chatUser.id,
                    extraData = mutableMapOf(
                        "name" to args.chatUser.name,
                        "country" to "india",
                        "image" to "https"
                    )
                )
            } else {
                User(
                    id = args.chatUser.id,
                    extraData = mutableMapOf(
                        "name" to args.chatUser.name
                    )
                )
            }
            val token = client.devToken(user.id)
            client.connectUser(
                user, token
            ).enqueue { result ->
                if (result.isSuccess) {
                    Log.d("Channel", "Sucess")
                } else {
                    Log.d("Channel", result.error().message.toString())
                }
            }
        }
    }

}