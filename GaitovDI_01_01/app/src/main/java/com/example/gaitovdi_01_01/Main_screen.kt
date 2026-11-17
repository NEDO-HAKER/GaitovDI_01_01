package com.example.gaitovdi_01_01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Main_screen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_screen, container, false)

        val A = listOf("байт", "килобайт", "мегабайт", "гигабайт")

        val numberPicker = view?.findViewById<EditText>(R.id.pick1)
        val _from = view?.findViewById<EditText>(R.id.et2)
        val _to = view?.findViewById<EditText>(R.id.et3)
        val button = view?.findViewById<Button>(R.id.bt1)
        val etres = view?.findViewById<EditText>(R.id.et4)

        button?.setOnClickListener {
            try {
                if (!_to?.text.isNullOrEmpty() && !_from?.text.isNullOrEmpty()) {
                    val from = _from?.text.toString().trim().lowercase()
                    val to = _to?.text.toString().trim().lowercase()
                    if (from in A && to in A) {
                        val number = numberPicker?.text.toString().toDouble() ?: 10.0

                        val factorFrom = when (from) {
                            "байт" -> 1.0
                            "килобайт" -> 1024.0
                            "мегабайт" -> 1024.0 * 1024
                            "гигабайт" -> 1024.0 * 1024 * 1024
                            else -> 1.0
                        }

                        val factorTo = when (to) {
                            "байт" -> 1.0
                            "килобайт" -> 1024.0
                            "мегабайт" -> 1024.0 * 1024
                            "гигабайт" -> 1024.0 * 1024 * 1024
                            else -> 1.0
                        }

                        val result = number * (factorFrom / factorTo)

                        val output = if (result == result.toLong().toDouble()) {
                            result.toLong().toString()
                        } else {
                            result.toString()
                        }

                        etres?.setText(output)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Не найдено такой ед. измерения",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Заполните пустые поля",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            catch (e: NumberFormatException) {
                Toast.makeText(
                    requireContext(),
                    "Некорректный ввод",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return view
    }
}