package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity: AppCompatActivity() {
    val TAG = "MyApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var team = ArrayList<Standable>()
        var JoJo = Joutarou()
        var Dio = Dio()
        var Iggy = Iggy()
        team.add(Iggy)
        Log.i(TAG, "$Iggy has added to team")
        team.add(JoJo)
        Log.i(TAG, "$JoJo has added to team")
        team.add(Dio)
        Log.i(TAG, "$Dio has added to team")

        for (standable in team) {
            standable.invokeStand()
        }

        Log.i(TAG, "$Dio, $JoJo and $Iggy has just invoke them stands")

        if (team.contains(JoJo) && team.contains(Dio)) {
            for (i in 0..3) {
                JoJo.ora()
                Dio.muda()
            }
        }

        Log.i(TAG, "A battle between $Dio and $JoJo has just been")

        var commonDog:Dog = CommonDog()

        Dio.killDog(commonDog)
        Log.i(TAG, "$Dio is going to kill a dog")
        Dio.killDog(Iggy)
        Log.i(TAG, "$Dio is going to kill another dog")
        Log.i(TAG, "commonDog's isAlive is ${commonDog.isAlive}")
        loge("Iggy's isAlive is ${Iggy.isAlive}")  // use of inline function

        JoJo.coolHat()
        JoJo.hat = "pink scarf"
        JoJo.coolHat()
        Dio.coolHat()
        Dio.hat = null
        Dio.coolHat()
        loge("$JoJo and $Dio has just tried on clothes")

        Iggy.isGum()
        Iggy.gum = "chocolate gum"
        Iggy.isGum()
        commonDog.isGum()
        commonDog.gum = "chocolate gum"
        commonDog.isGum()
        loge("$Iggy and $commonDog has just eaten a gum")
    }

    inline fun loge(message: String) {
        Log.i(TAG, message)
    }
}