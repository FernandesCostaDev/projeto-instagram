package com.example.instagram.login.view.register.view.data

import com.example.instagram.login.view.common.model.UserAuth

interface RegisterEmailCallback {
    fun onSeccess()
    fun onFailure(message: String)
    fun onComplete()
}