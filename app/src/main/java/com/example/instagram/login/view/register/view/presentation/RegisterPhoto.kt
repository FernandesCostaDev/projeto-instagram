package com.example.instagram.login.view.register.view.presentation

import android.net.Uri
import androidx.annotation.StringRes
import com.example.instagram.login.view.common.base.BasePresenter
import com.example.instagram.login.view.common.base.BaseView

interface RegisterPhoto {
    //interface para fazer a confirmação dos dados
    interface Presenter: BasePresenter {
        fun updateUser(photoUri: Uri)
    }

    //interface que vai retornar a msg de erro para activity de view do RegisterActivity
    interface View: BaseView<Presenter> {
        //O que a view vai exibir?
        fun showProgress(enabled: Boolean)
        fun onUpdateFailure(message: String)
        fun onUpdateSuccess()
    }
}