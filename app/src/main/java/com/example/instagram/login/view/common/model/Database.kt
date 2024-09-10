package com.example.instagram.login.view.common.model

import java.util.UUID

//Esse Database não é como outro, quando o app é fechado ele é apagado da memória
object Database {
    val usersAuth = hashSetOf<UserAuth>()
    val photos = hashSetOf<Photo>()

    //variável responsável por armazenar o usuário autenticado
    var sessionAuth: UserAuth? = null

    //init vai inicar o objeto
    init {
        usersAuth.add(UserAuth(UUID.randomUUID().toString(),"userA","userA@gmail.com","12345678"))
        usersAuth.add(UserAuth(UUID.randomUUID().toString(),"UserB","userB@gmail.com","87654321"))
    }
}