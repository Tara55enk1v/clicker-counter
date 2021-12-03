package com.example.textinputs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    var usersClicks = mutableMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickBtn = findViewById<Button>(R.id.btn)
        val clickCounter = findViewById<TextView>(R.id.textView)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.nameText)

        clickBtn.setOnClickListener {
            val userName = userNameTextInputView.editText?.text?.toString()
            val maskedUserName =
                if (userName.isNullOrEmpty()) "Somebody"
                else userName
            val oldCounter = usersClicks[maskedUserName] ?: 0
            val newCounter = oldCounter + 1
            usersClicks[maskedUserName] = newCounter

            clickCounter.text = "$maskedUserName clicked $newCounter times"
        }
    }
}