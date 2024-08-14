package com.example.instagram.login.view.register.view.data

import android.os.Handler
import android.os.Looper
import com.example.instagram.login.view.common.model.Database
import com.example.instagram.login.view.common.model.UserAuth
import java.util.UUID

class FakeRegisterEmailDataSource : RegisterDataSource {

    override fun create(email: String, callback: RegisterCallback) {
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

    override fun create(email: String, name: String, password: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed(
            {

                // depois de 2 segundos...
                val userAuth = Database.usersAuth.firstOrNull { email == it.email }

                if (userAuth != null) {
                    callback.onFailure("Usuário já cadastrado")
                } else {
                    val created = Database.usersAuth.add(
                        UserAuth(
                            UUID.randomUUID().toString(),
                            email, name, password
                        )
                    )
                    if (created) {
                        callback.onSeccess()
                    } else {
                        callback.onFailure("Erro interno no servidor.")
                    }
                }

                callback.onComplete()
            }, 2000
        )
    }
}
