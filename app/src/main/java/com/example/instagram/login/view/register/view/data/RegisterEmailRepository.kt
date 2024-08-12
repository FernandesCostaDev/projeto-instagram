package com.example.instagram.login.view.register.view.data

import com.example.instagram.login.view.login.data.LoginCallback

class RegisterEmailRepository(private val dataSource: RegisterEmailDataSource)  {

    fun create(email: String, callback:RegisterEmailCallback){
        //vai ser responsável por decidir o que fazer com esses dados
        //servidor ou banco de dados local
        //salvar localmente algum dado
        //só chamar servidor
        //só chamar banco de dados local
        dataSource.create(email, callback)

    }

}