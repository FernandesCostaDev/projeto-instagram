package com.example.instagram.login.view.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.instagram.R
import com.example.instagram.databinding.DialogCustomBinding

class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var bindig: DialogCustomBinding
    private lateinit var txtButtons: Array<TextView>

    private var titleId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        bindig = DialogCustomBinding.inflate(layoutInflater)
        setContentView(bindig.root)
    }

    override fun setTitle(titleId: Int) {
        this.titleId = titleId
    }

    fun addButton(vararg texts: Int, listener: View.OnClickListener) {
        txtButtons = Array(texts.size) {
            TextView(context)
        }

        texts.forEachIndexed { index, txtId ->
            txtButtons[index].id = txtId
            txtButtons[index].setText(txtId)
            txtButtons[index].setOnClickListener{
             listener.onClick(it)
             dismiss()
            }
        }
    }
    override fun show(){
        super.show()

        titleId?. let{
           bindig.dialogTitle.setText(it)
        }

        for(txtView in txtButtons){
            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(30, 50, 30, 50)
            bindig.dialogContainer.addView(txtView, layoutParams)
        }
    }
}



