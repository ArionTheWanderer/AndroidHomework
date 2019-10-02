package com.example.myapplication

class Dio: Standable {
    override val stand: String = "The World"
    val battleRoar: String = "MUDA"
    var hat: String? = "pink scarf"

    fun coolHat() {
        if (hat != null) println("Take this $hat off!")
        else print("I hate hats, especially black")
    }

    fun muda() {
        print(battleRoar)
    }

    fun killDog(dog: Dog): Dog {
        if (dog.isAlive == true && !dog.isReasonable) dog.isAlive = false
        else if (dog.isReasonable) println("*Dog ran away*")
        return dog
    }

}