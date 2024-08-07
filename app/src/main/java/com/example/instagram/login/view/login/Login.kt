package com.example.instagram.login.view.login

import com.example.instagram.login.view.common.base.BasePresenter
import com.example.instagram.login.view.common.base.BaseView

interface Login {

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
        interface Presenter : BasePresenter {
            fun login(email: String, password: String)
        }
    }
