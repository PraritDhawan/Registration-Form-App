package com.nopalyer.registrationform

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
   lateinit var tvUsername: EditText
   lateinit var tvfirstName: EditText
   lateinit var tvlastName: EditText
   lateinit var tvPassword: EditText
   lateinit var btnRegister: Button
   lateinit var img1: ImageView
   lateinit var img2: ImageView
   lateinit var img3: ImageView
   lateinit var img4: ImageView
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvUsername = findViewById(R.id.et_userName)
        tvfirstName =findViewById(R.id.et_firstName)
        tvlastName =findViewById(R.id.et_lastName)
        this.tvPassword = findViewById(R.id.et_password)
        this.btnRegister = findViewById(R.id.btnRegister)
        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
       
        tvPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (hasLength(s)) {
                    img1.setImageResource(R.drawable.checked)
                } else {
                    img1.setImageResource(R.drawable.unchecked)
                }
                if (hasSymbol(s)) {
                    img4.setImageResource(R.drawable.checked)
                } else {
                    img4.setImageResource(R.drawable.unchecked)
                }
                if (hasDigit(s)) {
                    img3.setImageResource(R.drawable.checked)
                } else {
                    img3.setImageResource(R.drawable.unchecked)
                }
                if (hasUppercase(s)) {
                    img2.setImageResource(R.drawable.checked)
                } else {
                    img2.setImageResource(R.drawable.unchecked)
                }
                if (hasLength(s) && hasUppercase(s) && hasDigit(s) && hasSymbol(s)) {
                    btnRegister.visibility = View.VISIBLE
                } else {
                    btnRegister.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    fun hasLength(value: CharSequence): Boolean {
        return value.toString().length >= 8
    }

    fun hasDigit(value: CharSequence): Boolean {
        return value.toString() .contains(("[0-9]".toRegex()))
    }

    fun hasUppercase(value: CharSequence): Boolean {
        val s = value.toString()
        return s.contains("[A-Z]".toRegex())
    }

    fun hasSymbol(value: CharSequence): Boolean {
        return value.contains("[!@#$*/*]".toRegex())
    }
    }
