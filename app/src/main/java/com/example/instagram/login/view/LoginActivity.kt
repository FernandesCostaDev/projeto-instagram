package com.example.instagram.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var bindig: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        with(bindig) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(watcher)

            loginBtnEnter.setOnClickListener {

                loginBtnEnter.showProgress(true)

                loginEditEmail.error = "Esse e-mail é inválido."
                loginEditPasswordInput.error = "Senha incorreta."

                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        bindig.loginBtnEnter.showProgress(false)
                    }, 2000
                )
            }
        }
    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            bindig.loginBtnEnter.isEnabled = s.toString().isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }
}