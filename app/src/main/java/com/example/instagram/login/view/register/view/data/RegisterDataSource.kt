package com.example.instagram.login.view.register.view.data

interface RegisterDataSource {
    fun create(email: String, callback: RegisterCallback)

    fun create(email: String, name: String, password: String, callback: RegisterCallback)

}