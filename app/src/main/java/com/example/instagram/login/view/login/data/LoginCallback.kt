package com.example.instagram.login.view.login.data

import com.example.instagram.login.view.common.model.UserAuth

interface LoginCallback {
    fun onSeccess(userAuth: UserAuth)
    fun onFailure(message: String)
    fun onComplete()
}