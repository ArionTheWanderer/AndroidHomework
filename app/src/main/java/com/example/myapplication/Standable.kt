package com.example.myapplication

interface Standable {
    val stand: String

    fun invokeStand() {
        println(stand + "!")
    }
}