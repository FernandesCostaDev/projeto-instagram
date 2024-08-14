package com.example.instagram.login.view.register.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.databinding.ActivityRegisterBinding
import com.example.instagram.login.view.main.view.MainActivity
import com.example.instagram.login.view.register.view.RegisterNamePasswordFragment.Companion.KEY_EMAIL

class RegisterActivity : AppCompatActivity(), FragmentAttachListener {

    private lateinit var bindig: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        val fragment = RegisterEmailFragment()
        replaceFragment(fragment)
    }

    override fun goToNameAndPasswordScreen(email: String) {
     //Passagem de valor entre fragmentos
        val args = Bundle()
        args.putString(KEY_EMAIL, email)
        val fragment = RegisterNamePasswordFragment()
        fragment.arguments = args
        replaceFragment(fragment)
    }

    override fun goToWelcomeScreen(name: String) {
        val fragment = RegisterWelcomeFragment().apply {
            arguments = Bundle().apply {
                putString(RegisterWelcomeFragment.KEY_NAME, name)
            }
        }
        replaceFragment(fragment)
    }

    override fun goToPhotoScreen() {
        val fragment = RegisterPhotoFragment()
        replaceFragment(fragment)
    }

    override fun goToMainScreen() {
       val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {

        if (supportFragmentManager.findFragmentById(R.id.register_fragment) == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.register_fragment, fragment)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.register_fragment, fragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}