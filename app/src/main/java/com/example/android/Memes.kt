package com.example.android

object Memes {
    private var list = ArrayList<Meme>()

    init {
        list.add(
            Meme(
                "Student",
                "Nice higher education",
                ArrayList<Int>().apply {
                    add(R.drawable.chacha)
                    add(R.drawable.kvas)
                })
        )
        list.add(
            Meme(
                "Memer",
                "I laughed for 3 days lol XD",
                ArrayList<Int>().apply {
                    add(R.drawable.dopka)
                    add(R.drawable.papizi)
                    add(R.drawable.commits)
                })
        )
        list.add(
            Meme(
                "Advertisement",
                "Best offers for our followers!",
                ArrayList<Int>().apply {
                    add(R.drawable.stop_it)
                    add(R.drawable.vakansiya)
                })
        )
    }

    fun getData() = list

}