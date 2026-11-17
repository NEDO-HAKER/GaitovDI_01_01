package com.example.gaitovdi_01_01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Log_in : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.log_in, container, false)

        val button = view.findViewById<Button>(R.id.bt1)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_mainScreenFragment)
        }

        return view
    }

}
