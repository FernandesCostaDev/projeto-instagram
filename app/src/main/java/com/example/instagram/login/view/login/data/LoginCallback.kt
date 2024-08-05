package com.example.instagram.login.view.login.data

interface LoginCallback {
    fun onSeccess()
    fun onFailure(message: String)
    fun onComplete()
}