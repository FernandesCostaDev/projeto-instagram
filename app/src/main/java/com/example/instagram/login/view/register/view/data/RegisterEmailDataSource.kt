package com.example.instagram.login.view.register.view.data

interface RegisterEmailDataSource {
    fun create(email: String, callback: RegisterEmailCallback)
}