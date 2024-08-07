package com.example.instagram.login.view.register.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.R
import com.example.instagram.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var bindig: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        val fragment = RegisterEmailFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.register_fragment, fragment)
            commit()
        }
    }
}