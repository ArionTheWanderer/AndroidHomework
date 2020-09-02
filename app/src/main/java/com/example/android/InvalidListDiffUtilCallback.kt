package com.example.android

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil

class InvalidListDiffUtilCallback(
    private val oldList: List<Invalid>,
    private val newList: List<Invalid>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]
        return old.name == new.name
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]
        return old.disease == new.disease
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        // return super.getChangePayload(oldItemPosition, newItemPosition)
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        val diffBundle = Bundle()
        if (oldItem.name != newItem.name) {
            diffBundle.putString("KEY_NAME", newItem.name)
        }
        if (oldItem.disease != newItem.disease) {
            diffBundle.putString("KEY_DISEASE", newItem.disease)
        }
        /*if (oldItem.name != newItem.name || oldItem.disease != newItem.disease) {
            diffBundle.putInt("KEY_ID", newItem.id)
        }*/
        return if (diffBundle.isEmpty) null else diffBundle
    }
}