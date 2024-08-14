package com.example.instagram.login.view.register.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.databinding.FragmentRegisterEmailBinding
import com.example.instagram.databinding.FragmentRegisterNamePasswordBinding
import com.example.instagram.login.view.common.base.DependencyInjector
import com.example.instagram.login.view.common.util.TxtWatcher
import com.example.instagram.login.view.register.view.presentation.RegisterEmailPresenter
import com.example.instagram.login.view.register.view.presentation.RegisterNameAndPassworPresenter

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password),RegisterNameAndPassword.View{

    private var binding: FragmentRegisterNamePasswordBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null
    override lateinit var presenter: RegisterNameAndPassword.Presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)
        val repository = DependencyInjector.registerEmailRepository()
        presenter = RegisterNameAndPassworPresenter(this, repository)

        //Recebendo o valor do fragmento anterior
        val email = arguments?.getString(KEY_EMAIL)?: throw IllegalArgumentException("email not found")

        binding?.let {
            with(it) {
                registerTxtLogin.setOnClickListener {
                    activity?.finish()
                }

                registerNameBtnNext.setOnClickListener {
                    //passando os valores para próximo fragmento
                    presenter.create(
                        email,
                        registerEditName.text.toString(),
                        registerEditPassword.text.toString(),
                        registerEditConfirm.text.toString())
                }

                registerEditName.addTextChangedListener(watcher)
                registerEditPassword.addTextChangedListener(watcher)
                registerEditConfirm.addTextChangedListener(watcher)

                //quando o usuário começar a digitar a msg de erro vai sumir
                registerEditName.addTextChangedListener(TxtWatcher{
                    displayNameFailure(null)
                })
                registerEditPassword.addTextChangedListener(TxtWatcher{
                    displayPasswordFailure(null)
                })

                registerEditConfirm.addTextChangedListener(TxtWatcher{
                    displayPasswordFailure(null)
                })
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener){
            fragmentAttachListener = context
        }
    }

    private val watcher = TxtWatcher{
        binding?.registerNameBtnNext?.isEnabled = binding?.registerEditName?.text.toString().isNotEmpty()
                && binding?.registerEditPassword?.text.toString().isNotEmpty()
                && binding?.registerEditConfirm?.text.toString().isNotEmpty()
    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }

    companion object{
        const val KEY_EMAIL = "key_email"
    }

    override fun showProgress(enabled: Boolean) {
       binding?.registerNameBtnNext?.showProgress(enabled)
    }

    override fun displayNameFailure(nameError: Int?) {
       binding?.registeEditNameInput?.error = nameError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding?.registerEditPasswardInput?.error = passwordError?.let { getString(it) }
    }

    override fun onCreateSuccess(name: String) {
       fragmentAttachListener?.goToWelcomeScreen(name)
    }

    override fun onCreateFailure(message: String) {
        //Vai mostrar tela de erro
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }


}