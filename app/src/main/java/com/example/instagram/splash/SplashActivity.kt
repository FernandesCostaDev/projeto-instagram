package com.example.instagram.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivitySplashBinding
import com.example.instagram.login.view.LoginActivity
import com.example.instagram.login.view.common.base.DependencyInjector
import com.example.instagram.login.view.main.view.MainActivity
import com.example.instagram.splash.Splash
import com.example.instagram.splash.presentation.SplashPresenter

class SplashActivity : AppCompatActivity(), Splash.View {
    private lateinit var binding: ActivitySplashBinding
    override lateinit var presenter: Splash.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository =  DependencyInjector.splashRepository()
        presenter = SplashPresenter(this, repository)
        presenter.authenticated()
    }

    override fun goToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goToLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}