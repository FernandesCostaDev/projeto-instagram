package com.example.instagram.login.view.register.view.data

import android.net.Uri

class RegisterRepository(private val dataSource: RegisterDataSource)  {

    fun create(email: String, callback:RegisterCallback){
        //vai ser responsável por decidir o que fazer com esses dados
        //servidor ou banco de dados local
        //salvar localmente algum dado
        //só chamar servidor
        //só chamar banco de dados local
        dataSource.create(email, callback)

    }

    fun create(email: String, name: String, password: String, callback: RegisterCallback){
        dataSource.create(email, name, password,callback)
    }

    fun updateUser(photoUri: Uri, callback: RegisterCallback){
        dataSource.updateUser(photoUri, callback)
    }
}