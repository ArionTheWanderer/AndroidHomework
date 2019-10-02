package com.example.myapplication

class CommonDog: Dog {
    override var isAlive: Boolean = true
    override val isReasonable: Boolean = false
    override var gum: String? = null

    override fun woof() {
        if(isAlive)
            println("Woof!")
    }

    override fun isGum() {
        if (gum == null)
            woof()
        else woof(); woof()
    }
}