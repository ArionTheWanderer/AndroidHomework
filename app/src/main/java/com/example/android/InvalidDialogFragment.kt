package com.example.android

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_invalid_dialog.*
import java.lang.Integer.parseInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
const val INV_NAME = "INV_NAME"
const val INV_DISEASE = "INV_DISEASE"
const val INV_NUMBER = "INV_NUMBER"

class InvalidDialogFragment() : DialogFragment() {
    private var listener: PopupClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? PopupClickListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invalid_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_add.setOnClickListener {
            val input = Bundle()

            val name = et_name.text?.toString()
            val disease = et_disease.text?.toString()
            val number = et_number.text?.toString()

            if (name != null && name != "") input.putString(INV_NAME, et_name.text?.toString())
            if (disease != null && disease != "") input.putString(
                INV_DISEASE,
                et_disease.text?.toString()
            )
            if (number != null && number != "") input.putInt(INV_NUMBER, parseInt(number))
            listener?.onPositiveClick(input) ?: Toast.makeText(
                activity,
                "Не приаттачилось",
                Toast.LENGTH_SHORT
            ).show()
            dismiss()
        }
        btn_cancel.setOnClickListener {
            dismiss()
        }
    }

    interface PopupClickListener {
        fun onPositiveClick(input: Bundle?)
    }
}
