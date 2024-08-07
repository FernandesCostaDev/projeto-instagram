package com.example.instagram.login.view.login.data

import android.os.Handler
import android.os.Looper
import com.example.instagram.login.view.common.model.Database

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
                // depois de 2 segundos...
           val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            when {
                userAuth == null -> {
                    callback.onFailure("Usuário não encontrado")
                }
                userAuth.password != password -> {
                    callback.onFailure("Senha está incorreta")
                }
                else -> {
                    Database.sessionAuth = userAuth
                    callback.onSeccess(userAuth)
                }
            }

                callback.onComplete()
            }, 2000
        )
    }
}