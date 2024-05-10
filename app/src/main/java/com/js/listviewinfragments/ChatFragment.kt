package com.js.listviewinfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView


class ChatFragment : Fragment() {

    lateinit var userName: String
    var chatEditText: EditText? = null
    var chatButton:Button? = null
    var chatList = mutableListOf<Chat>()
    var msgChatList: ListView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = requireArguments().getString("username", "brak nazwy użytkownika")
        view.findViewById<TextView>(R.id.textview_user_name).text = userName

        chatEditText = view.findViewById(R.id.edittext_chat_text)
        chatButton = view.findViewById(R.id.button_chat_text)
        msgChatList = view.findViewById(R.id.listview_chat_text)

//        val adapter = ArrayAdapter(requireActivity(), R.layout.simple_list_items, R.id.textview_chat_text_show, chatList)
//        msgChatList?.adapter= adapter
//
        val adapter = ChatListAdapter(requireActivity(), chatList)
        msgChatList?.adapter = adapter

        chatButton?.setOnClickListener {
//            chatList.add(chatEditText?.text.toString())
             chatList.add(Chat(userName=userName, chatText = chatEditText?.text.toString()  ))

            // trzeba powiadomić adapter, że dane się zmieniły
            adapter.notifyDataSetChanged()

            chatEditText?.text?.clear()
        }
    }
}