package com.js.listviewinfragments

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ChatListAdapter(
    private val context: Activity,
    private  val chatList: MutableList<Chat>
) : ArrayAdapter<Chat>(context, R.layout.chat_list_layout, chatList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // używając context.layoutInflater, uzyskujemy referencję do LayoutInflater
        // dostosowanego do konkretnego kontekstu aplikacji,
        // co pozwala na nadmuchnięcie widoków zgodnie z kontekstem, w którym są używane.
        val inflater = context.layoutInflater
        val view: View = convertView ?: inflater.inflate(
            R.layout.chat_list_layout,
            parent,
            false
        )

        val chattingUser = view.findViewById<TextView>(R.id.textview_chatuser)
        val chattingText = view.findViewById<TextView>(R.id.textview_chattext)

        val chat = chatList[position]
        chattingUser.text = chat.userName
        chattingText.text = chat.chatText


        return view

    }

}