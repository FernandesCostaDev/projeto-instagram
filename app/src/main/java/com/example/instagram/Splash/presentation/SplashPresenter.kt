package com.example.instagram.Splash.presentation

import com.example.instagram.Splash.Splash
import com.example.instagram.Splash.data.SplashCallback
import com.example.instagram.Splash.data.SplashRepository

class SplashPresenter(private var view: Splash.View?, private val repository: SplashRepository) :
    Splash.Presenter {
    override fun authenticated() {
        repository.session(object : SplashCallback {
            override fun onSuccess() {
                view?.goToMainScreen()
            }

            override fun onFailure() {
                view?.goToLoginScreen()
            }
        })
    }

    override fun onDestroy() {
        view = null
    }
}
