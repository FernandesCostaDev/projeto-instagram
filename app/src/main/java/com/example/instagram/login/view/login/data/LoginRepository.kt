package com.example.instagram.login.view.login.data

class LoginRepository(private val dataSource: LoginDataSource)  {

    fun login(email: String, password: String, callback: LoginCallback){
        //vai ser responsável por decidir o que fazer com esses dados
        //servidor ou banco de dados local
        //salvar localmente algum dado
        //só chamar servidor
        //só chamar banco de dados local
        dataSource.login(email, password, callback)

    }

}