package com.example.instagram.splash.data

import com.example.instagram.login.view.common.model.Database

class FakeLocalDataSource: SplashDataSource {
    override fun session(callback: SplashCallback) {
      if (Database.sessionAuth != null) {
        callback.onSuccess()
      }else{
          callback.onFailure()
      }
    }
}