package com.example.u2r1_conceptoskotlin

fun main() {
    val song = Song(
        title = "Himno de la Alegría",
        artist = "Ludwig van Beethoven",
        yearPublished = 1824,
        playCount = 1500
    )

    song.printDescription()
}

class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, interpretada por $artist, se lanzó en $yearPublished")
    }
}