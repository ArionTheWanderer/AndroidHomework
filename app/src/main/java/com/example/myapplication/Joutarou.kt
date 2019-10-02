package com.example.myapplication

class Joutarou: Standable {
    override val stand: String = "Star Platinum"
    val battleRoar: String = "ORA"
    var hat: String? = null

    fun coolHat() {
        if (hat == null) println("Where's my hat?")
        else print("$hat is my secret of power")
    }

    fun ora() {
        print(battleRoar)
    }

}