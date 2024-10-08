package com.example.instagram.login.view.register.view.presentation

import android.util.Patterns
import com.example.instagram.R
import com.example.instagram.login.view.register.view.RegisterEmail
import com.example.instagram.login.view.register.view.data.RegisterCallback
import com.example.instagram.login.view.register.view.data.RegisterRepository

class RegisterEmailPresenter(private var view: RegisterEmail.View?, private val repository: RegisterRepository) : RegisterEmail.Presenter {

    override fun create(email: String) {

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (isEmailValid) {
            view?.showProgress(true)

            repository.create(email, object : RegisterCallback {
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