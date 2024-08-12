package com.example.instagram.login.view.register.view

import androidx.annotation.StringRes
import com.example.instagram.login.view.common.base.BasePresenter
import com.example.instagram.login.view.common.base.BaseView

interface RegisterEmail {

    interface Presenter: BasePresenter{
        fun create(email: String)
    }

    //interface que vai retornar a msg de erro para activity de view do RegisterActivity
    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun onEmailFailure(message: String)
        fun goToNameAndPasswordScreen(email: String)

    }
}