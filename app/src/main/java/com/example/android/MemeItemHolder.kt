package com.example.android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_meme.*


class MemeItemHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    fun bind(meme: Meme) {
        profile_name.text = meme.name
        tv_description.text = meme.description
        vp.adapter = ViewPagerAdapter(containerView.context, meme.resources)
    }

    private inner class ViewPagerAdapter(var mContext: Context, var picsList: List<Int>) :
        PagerAdapter() {
        override fun isViewFromObject(view: View, `object`: Any): Boolean =
            view == `object`

        override fun getCount(): Int = picsList.size

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as AppCompatImageView)
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val li = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemView = li.inflate(R.layout.pager, container, false) as? AppCompatImageView
            itemView?.setImageResource(picsList[position])
            container.addView(itemView)
            return itemView as Any
        }
    }

    companion object {
        fun create(parent: ViewGroup) = MemeItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_meme,
                parent,
                false
            )
        )
    }
}
