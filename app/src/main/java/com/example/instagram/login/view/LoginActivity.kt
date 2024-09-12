package com.example.instagram.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityLoginBinding
import com.example.instagram.login.view.common.base.DependencyInjector
import com.example.instagram.login.view.common.util.TxtWatcher
import com.example.instagram.login.view.login.Login
import com.example.instagram.login.view.login.presentation.LoginPresenter
import com.example.instagram.login.view.main.view.MainActivity
import com.example.instagram.login.view.register.view.RegisterActivity

class LoginActivity : AppCompatActivity(), Login.View {
    private lateinit var bindig: ActivityLoginBinding
    override lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        presenter = LoginPresenter(this, DependencyInjector.loginRepository())

        with(bindig) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditEmail.addTextChangedListener(TxtWatcher {
                displayEmailFailure(null)
            })

            loginEditPassword.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(TxtWatcher {
                displayPasswordFailure(null)
            })

            loginBtnEnter.setOnClickListener {
              //VAI CHAMAR O PRESENTER
                presenter.login(loginEditEmail.text.toString(), loginEditPassword.text.toString())
            }

            loginTxtRegister.setOnClickListener {
                goToRegisterScreen()
            }

        }
    }

    private fun goToRegisterScreen() {
       startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher{
        bindig.loginBtnEnter.isEnabled = bindig.loginEditEmail.text.toString().isNotEmpty() &&
                bindig.loginEditPassword.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        bindig.loginBtnEnter.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        bindig.loginEditEmailInput.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        bindig.loginEditPasswordInput.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
      val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
      startActivity(intent)
    }

    override fun onUserUnauthorized(message: String) {
       Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

/*
Looper do progress bar

)
*/