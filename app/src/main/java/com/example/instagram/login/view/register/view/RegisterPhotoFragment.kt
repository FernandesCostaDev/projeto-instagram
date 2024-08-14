package com.example.instagram.login.view.register.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.databinding.FragmentRegisterPhotoBinding
import com.example.instagram.login.view.common.view.CustomDialog

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {

    private var bindig: FragmentRegisterPhotoBinding? = null

    //para iniciar a próximo fragmento
    private var fragmentAttachListener: FragmentAttachListener? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindig = FragmentRegisterPhotoBinding.bind(view)

        bindig?.let {
            with(it) {
                registerBtnJump.setOnClickListener {
                    fragmentAttachListener?.goToMainScreen()
                }
                registerBtnNext.isEnabled = true
                registerBtnNext.setOnClickListener {
                    val customDialog = CustomDialog(requireContext())

                    //customDialog.setTitle(R.string.app_name)
                    customDialog.addButton(R.string.photo, R.string.gallery) {
                        when (it.id) {
                            R.string.photo -> {
                                Log.i("Teste", "photo")
                            }

                            R.string.gallery -> {
                                Log.i("Teste", "gallery")
                            }
                        }
                    }
                    customDialog.show()
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener) {
            fragmentAttachListener = context
        }
    }

    override fun onDestroy() {
        bindig = null
        super.onDestroy()
    }
}