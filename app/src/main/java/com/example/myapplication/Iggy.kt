package com.example.myapplication

class Iggy: Standable, Dog{
    override val stand: String = "The Fool"
    override var isAlive: Boolean = true
    override val isReasonable: Boolean = true
    override var gum: String? = null

    override fun isGum() {
        if (gum == null)
            woof()
        else println("*Happy*")
    }

    override fun woof() {
        println("Woof, bastard!")
    }
}