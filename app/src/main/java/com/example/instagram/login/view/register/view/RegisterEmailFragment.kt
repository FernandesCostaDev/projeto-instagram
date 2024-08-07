package com.example.instagram.login.view.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.databinding.FragmentRegisterEmailBinding
import com.example.instagram.login.view.common.util.TxtWatcher

class RegisterEmailFragment : Fragment (R.layout.fragment_register_email), RegisterEmail.View{

   private var binding: FragmentRegisterEmailBinding? = null
   override lateinit var presenter: RegisterEmail.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterEmailBinding.bind(view)

        binding?.let {
            with(it){
               registerTxtLogin.setOnClickListener {
                   activity?.finish()
               }

                registerBtnNext.setOnClickListener {
                    presenter.create(
                        registerEditEmail.text.toString()
                    )
                }

                registerEditEmail.addTextChangedListener(watcher)
                registerEditEmail.addTextChangedListener(TxtWatcher{
                    displayEmailFailure(null)
                })

            }
        }
    }

    override fun displayEmailFailure(emailError: Int?) {
    }

    override fun onDestroy() {
        binding = null
        //presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher{
       binding?.registerBtnNext?.isEnabled = binding?.registerEditEmail?.text.toString().isNotEmpty()
    }

}