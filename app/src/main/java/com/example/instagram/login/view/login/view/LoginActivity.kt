package com.example.instagram.login.view.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityLoginBinding
import com.example.instagram.login.view.common.util.TxtWatcher
import com.example.instagram.login.view.login.Login

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var bindig: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        with(bindig) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(watcher)

            loginBtnEnter.setOnClickListener {
                //VAI CHAMAR O PRESENTER
                /*Handler(Looper.getMainLooper()).postDelayed(
                    {
                        bindig.loginBtnEnter.showProgress(false)
                    }, 2000
                )*/
            }
        }
    }

    private val watcher = TxtWatcher{
        bindig.loginBtnEnter.isEnabled = it.isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        bindig.loginBtnEnter.showProgress(true)
    }

    override fun displayEmailFailure(emailError: Int?) {
        bindig.loginEditEmailInput.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        bindig.loginEditPasswordInput.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
       // IR PARA TELA PRINCIPAL
    }

    override fun onUserUnauthorized() {
        // MOSTRAR UM ALERTA
    }
}