package com.example.instagram.login.view.common.base

import com.example.instagram.Splash.data.FakeLocalDataSource
import com.example.instagram.Splash.data.SplashRepository
import com.example.instagram.login.view.login.data.FakeDataSource
import com.example.instagram.login.view.login.data.LoginRepository
import com.example.instagram.login.view.register.view.data.FakeRegisterDataSource
import com.example.instagram.login.view.register.view.data.RegisterRepository

object DependencyInjector {
    fun splashRepository(): SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }

}