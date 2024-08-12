package com.example.instagram.login.view.common.base

import com.example.instagram.login.view.login.data.FakeDataSource
import com.example.instagram.login.view.login.data.LoginRepository
import com.example.instagram.login.view.register.view.data.FakeRegisterEmailDataSource
import com.example.instagram.login.view.register.view.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterEmailRepository {
        return RegisterEmailRepository(FakeRegisterEmailDataSource())
    }

}