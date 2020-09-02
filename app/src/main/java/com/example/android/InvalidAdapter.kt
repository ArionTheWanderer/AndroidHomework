package com.example.android

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class InvalidAdapter(
    private var dataSource: ArrayList<Invalid>
) : RecyclerView.Adapter<InvalidItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvalidItemHolder =
        InvalidItemHolder.create(parent) {
            deleteInvalid(it)
        }

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: InvalidItemHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    override fun onBindViewHolder(
        holder: InvalidItemHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val o: Bundle = payloads[0] as Bundle
            var name = ""
            var disease = ""
            for (key in o.keySet()) {
                when (key) {
                    "KEY_NAME" -> {
                        name = o.getString(key).toString()
                    }
                    "KEY_DISEASE" -> {
                        disease = o.getString(key).toString()
                    }
                }
            }
            holder.bind(Invalid(name, disease))
        }
    }

    fun updateRV() {
        val invs: ArrayList<Invalid> = ArrayList()
        for (i in Invalids.getData()) {
            invs.add(Invalid(i.name, i.disease))
        }
        val gduc =
            InvalidListDiffUtilCallback(dataSource, invs)
        val res = DiffUtil.calculateDiff(gduc, true)
        dataSource.clear()
        dataSource.addAll(invs)
        res.dispatchUpdatesTo(this)
    }

    fun deleteInvalid(invalid: Invalid) {
        Invalids.deleteInvalid(invalid)
        updateRV()
    }
}
