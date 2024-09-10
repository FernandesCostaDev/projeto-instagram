package com.example.instagram.login.view.register.view.data

import android.net.Uri

interface RegisterDataSource {
    fun create(email: String, callback: RegisterCallback)

    fun create(email: String, name: String, password: String, callback: RegisterCallback)

    fun updateUser(photoUri: Uri, callback: RegisterCallback)


}