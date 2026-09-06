package com.example.u1r1introkotlin

fun main() {
    println(
        compareTime(
            timeSpentToday = 300,
            timeSpentYesterday = 250
        )
    )

    println(
        compareTime(
            timeSpentToday = 300,
            timeSpentYesterday = 300
        )
    )

    println(
        compareTime(
            timeSpentToday = 200,
            timeSpentYesterday = 220
        )
    )
}

fun compareTime(
    timeSpentToday: Int,
    timeSpentYesterday: Int
): Boolean {
    return timeSpentToday > timeSpentYesterday
}