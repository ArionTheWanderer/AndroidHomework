package com.example.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_memes.*

class MemesFragment : Fragment() {

    lateinit var adapter: MemeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val memes: ArrayList<Meme> = ArrayList()
        for (i in Memes.getData()) {
            memes.add(Meme(i.name, i.description, i.resources))
        }
        adapter = MemeAdapter(memes)
        rv_second.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = MemesFragment()
    }
}