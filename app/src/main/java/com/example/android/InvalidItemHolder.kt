package com.example.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_inv.*

class InvalidItemHolder(
    override val containerView: View,
    private val clickLambda: (Invalid) -> Unit
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(invalid: Invalid) {
        invalid_name.text = invalid.name
        invalid_dis.text = invalid.disease
        but_delete.setOnClickListener {
            clickLambda(invalid)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Invalid) -> Unit) =
            InvalidItemHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_inv, parent, false),
                clickLambda
            )
    }

}