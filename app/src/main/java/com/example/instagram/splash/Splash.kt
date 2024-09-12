package com.example.instagram.splash

import com.example.instagram.login.view.common.base.BasePresenter
import com.example.instagram.login.view.common.base.BaseView

interface Splash {
    interface Presenter: BasePresenter {
        fun authenticated()
    }

    interface View: BaseView<Presenter> {
        fun goToMainScreen()
        fun goToLoginScreen()
    }
}