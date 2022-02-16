package com.dedekurnn.aboutdede

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.dedekurnn.aboutdede.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myNameDede: MyName = MyName("Dede Kurniawan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myNameDede
        binding.doneButton.setOnClickListener { addNickName((it)) }

    }

    private fun addNickName(view: View) {

        binding.apply {
            myName?.name = nicknameEditText.text.toString()
            nicknameText.text = nicknameEditText.text
            nicknameText.visibility = View.VISIBLE
            nicknameEditText.visibility = View.GONE
            doneButton.visibility = View.GONE
            invalidateAll()
        }


        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}