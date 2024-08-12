package com.example.instagram.login.view.register.view.presentation

import android.util.Patterns
import com.example.instagram.R
import com.example.instagram.login.view.common.model.UserAuth
import com.example.instagram.login.view.login.Login
import com.example.instagram.login.view.login.data.LoginCallback
import com.example.instagram.login.view.login.data.LoginRepository
import com.example.instagram.login.view.register.view.RegisterEmail
import com.example.instagram.login.view.register.view.data.RegisterEmailCallback
import com.example.instagram.login.view.register.view.data.RegisterEmailRepository

class RegisterEmailPresenter(private var view: RegisterEmail.View?, private val repository: RegisterEmailRepository) : RegisterEmail.Presenter {

    override fun create(email: String) {

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (isEmailValid) {
            view?.showProgress(true)

            repository.create(email, object : RegisterEmailCallback {
                override fun onSeccess() {
                    view?.goToNameAndPasswordScreen(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }
            })
        }
    }

    override fun onDestroy() {
        view = null
    }
}