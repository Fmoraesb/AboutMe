package com.fernandomoraes.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fernandomoraes.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Fernando Moraes Bastos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.btnFeito.setOnClickListener {
            addNickName(it)
        }
        binding.tvNickname.setOnClickListener {
            updateNickName()
        }
    }

    private fun addNickName(view: View) {
        binding.apply {
            myName?.nickname = etNickname.text.toString()
            invalidateAll()
            binding.etNickname.visibility = View.GONE
            binding.btnFeito.visibility = View.GONE
            binding.tvNickname.visibility = View.VISIBLE
            hideKeyboard(view)
        }
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickName() {
        binding.apply {
            binding.etNickname.visibility = View.VISIBLE
            binding.btnFeito.visibility = View.VISIBLE
            binding.tvNickname.visibility = View.GONE
            binding.etNickname.requestFocus()
            showKeyboard(binding.etNickname)
        }
    }

    private fun showKeyboard(view: View) {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view, 0)
    }
}