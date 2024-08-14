package com.example.instagram.login.view.register.view.data

interface RegisterCallback {
    fun onSeccess()
    fun onFailure(message: String)
    fun onComplete()
}