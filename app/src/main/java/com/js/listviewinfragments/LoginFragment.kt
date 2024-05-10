package com.js.listviewinfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class LoginFragment : Fragment() {


    // tej metody nie musisz nadpisywać
    // zostanie wykonana metoda onCreate z rodzica
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    // w tej metodzie umieszczamy kod związany z obsługą
    // interakcji z użytkownikiem, ponieważ obiekty View we fragmencie  już istnieją
    // i mamy do nich dostęp przez view.findViewById
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextData: EditText = view.findViewById(R.id.edittext_username)
        val sendButton: Button = view.findViewById(R.id.button_send)

        sendButton.setOnClickListener {
            val dataToSend: String = editTextData.text.toString()
            val bundle = Bundle()
            bundle.putString("username", dataToSend)

            val chatFragment = ChatFragment()
            chatFragment.arguments = bundle


            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, chatFragment)
                .addToBackStack(null)
                .commit()
        }

    }


}