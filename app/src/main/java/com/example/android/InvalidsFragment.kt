package com.example.android

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_invalids.*

/**
 * A simple [Fragment] subclass.
 * Use the [InvalidsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InvalidsFragment : Fragment() {

    lateinit var adapter: InvalidAdapter
    private var fabListener: FabListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fabListener = context as? FabListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_invalids, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val invs: ArrayList<Invalid> = ArrayList()
        for (i in Invalids.getData()) {
            invs.add(Invalid(i.name, i.disease))
        }
        adapter = InvalidAdapter(invs)
        rv_invalids.adapter = adapter
        fab.setOnClickListener {
            fabListener?.onFabClick() ?: Snackbar.make(
                coordinator,
                "Не приаттачилась активити",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = InvalidsFragment()
    }

    interface FabListener {
        fun onFabClick()
    }


}
