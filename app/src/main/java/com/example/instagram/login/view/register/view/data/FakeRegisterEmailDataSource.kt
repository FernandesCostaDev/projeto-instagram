package com.example.instagram.login.view.register.view.data

import android.os.Handler
import android.os.Looper
import com.example.instagram.login.view.common.model.Database

class FakeRegisterEmailDataSource : RegisterEmailDataSource {

    override fun create(email: String, callback: RegisterEmailCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

                // depois de 2 segundos...
           val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callback.onSeccess()
            }else{
                callback.onFailure("Usuário já cadastrado")
            }
                callback.onComplete()
            }, 2000
        )
    }
}