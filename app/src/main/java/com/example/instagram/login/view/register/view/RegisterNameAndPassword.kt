package com.example.instagram.login.view.register.view

import androidx.annotation.StringRes
import com.example.instagram.login.view.common.base.BasePresenter
import com.example.instagram.login.view.common.base.BaseView

interface RegisterNameAndPassword {
    //interface para fazer a confirmação dos dados
    interface Presenter: BasePresenter {
        fun create(email: String,name: String, password: String, confirm: String)
    }

    //interface que vai retornar a msg de erro para activity de view do RegisterActivity
    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayNameFailure(@StringRes nameError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onCreateSuccess(name: String)
        fun onCreateFailure(message: String)
    }
}