package com.example.instagram.login.view.login.data

interface LoginDataSource {
    fun login(email: String, password: String, callback: LoginCallback)

}