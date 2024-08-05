package com.example.instagram.login.view.login.data

import android.os.Handler
import android.os.Looper

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                // depois de 2 segundos...

                if (email == "a@a.com" && password == "12345678") {
                    callback.onSeccess()

                } else {
                    callback.onFailure("Usuário não encontrado")
                }
                callback.onComplete()
            }, 2000
        )
    }
}