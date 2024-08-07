package com.example.instagram.login.view.common.base

import com.example.instagram.login.view.login.data.FakeDataSource
import com.example.instagram.login.view.login.data.LoginRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }
}