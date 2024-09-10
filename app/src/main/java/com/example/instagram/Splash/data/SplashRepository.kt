package com.example.instagram.Splash.data

class SplashRepository (private val dataSource: SplashDataSource){
    fun session(callback: SplashCallback){
        dataSource.session(callback)
    }
}