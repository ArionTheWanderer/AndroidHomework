package com.example.android

object Invalids {
    private var list = ArrayList<Invalid>()

    init {
        list.add(Invalid("Безрукий", "У него нет рук"))
        list.add(Invalid("Безногий", "У него нет ног"))
        list.add(Invalid("Максим", "Просто шиз"))
        list.add(Invalid("Ярополк", "НЕ БРАТ ТЫ МНЕ"))
        list.add(Invalid("Антоха", "2 балона по 2 с половой"))
        list.add(Invalid("Макнагетс", "Острые закончились :("))
        list.add(Invalid("777", "https://azino********.p**/"))
    }

    fun size(): Int = list.size
    fun getData(): ArrayList<Invalid> = list

    fun addInvalid(invalid: Invalid) {
        list.add(invalid)
    }

    fun addInvalid(name: String, disease: String) {
        list.add(Invalid(name, disease))
    }

    fun addInvalid(name: String, disease: String, position: Int) {
        list.add(position - 1, Invalid(name, disease))
    }

    fun deleteInvalid(invalid: Invalid) {
        list.remove(invalid)
    }
}