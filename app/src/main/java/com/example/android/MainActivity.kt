package com.example.android


import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), InvalidsFragment.FabListener,
    InvalidDialogFragment.PopupClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun setListener() {
        bnv_main.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.page_copyright -> {
                    openFragment(CopyrightFragment.newInstance(), "copyright")
                    true
                }
                R.id.page_invalids -> {
                    openFragment(InvalidsFragment.newInstance(), "invalids")
                    true
                }
                R.id.page_memes -> {
                    openFragment(MemesFragment.newInstance(), "invalids")
                    true
                }
                else -> false
            }
        }
        bnv_main.selectedItemId = R.id.page_invalids
    }

    private fun openFragment(fragment: Fragment, tag: String) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(container_main.id, fragment, tag)
        transaction.commit()
    }

    override fun onFabClick() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            fragmentTransaction.remove(prev)
        }
        fragmentTransaction.addToBackStack(null)
        val dialogFragment = InvalidDialogFragment()
        dialogFragment.show(fragmentTransaction, "dialog")
    }

    override fun onPositiveClick(input: Bundle?) {
        if (input != null) {
            val invalidsFragment =
                supportFragmentManager.findFragmentByTag("invalids") as? InvalidsFragment
            // val dialog = supportFragmentManager.findFragmentByTag("dialog") as? InvalidDialogFragment
            val name = input.getString(INV_NAME)
            val disease = input.getString(INV_DISEASE)
            val number: Int = input.getInt(INV_NUMBER)
            if (name != null && disease != null) {

                if (number != 0 && number > Invalids.size() || number == 0) {
                    Invalids.addInvalid(name, disease)
                    // dialog?.dismiss()
                    invalidsFragment?.adapter?.updateRV()
                } else if (number != 0) {
                    Invalids.addInvalid(name, disease, number)
                    // dialog?.dismiss()
                    invalidsFragment?.adapter?.updateRV()
                }
            } else {
                Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
