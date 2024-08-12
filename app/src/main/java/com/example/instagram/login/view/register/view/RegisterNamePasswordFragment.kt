package com.example.instagram.login.view.register.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.databinding.FragmentRegisterEmailBinding
import com.example.instagram.databinding.FragmentRegisterNamePasswordBinding
import com.example.instagram.login.view.common.base.DependencyInjector
import com.example.instagram.login.view.common.util.TxtWatcher
import com.example.instagram.login.view.register.view.presentation.RegisterEmailPresenter

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password){

    private var binding: FragmentRegisterNamePasswordBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)

        //Recebendo o valor do fragmento anterior
        val email = arguments?.getString(KEY_EMAIL)
        Log.i("teste",email.toString())

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object{
        const val KEY_EMAIL = "key_email"
    }
}