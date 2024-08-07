package com.example.instagram.login.view.common.model

import java.util.UUID

//Esse data base não é como outro, quando o app é fechado ele é apagado da memória
object Database {
    val usersAuth = hashSetOf<UserAuth>()

    //variável responsável por armazenar o usuário autenticado
    var sessionAuth: UserAuth? = null

    //init vai inicar o objeto
    init {
        usersAuth.add(UserAuth(UUID.randomUUID().toString(),"userA@gmail.com","12345678"))
        usersAuth.add(UserAuth(UUID.randomUUID().toString(),"userB@gmail.com","87654321"))
    }
}