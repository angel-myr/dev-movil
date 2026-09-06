package com.example.u1r1introkotlin

fun main() {
    printWeather(
        city = "Ankara",
        lowTemperature = 27,
        highTemperature = 31,
        chanceOfRain = 82
    )

    printWeather(
        city = "Tokyo",
        lowTemperature = 32,
        highTemperature = 36,
        chanceOfRain = 10
    )

    printWeather(
        city = "Cape Town",
        lowTemperature = 59,
        highTemperature = 64,
        chanceOfRain = 2
    )

    printWeather(
        city = "Guatemala City",
        lowTemperature = 50,
        highTemperature = 55,
        chanceOfRain = 7
    )
}

fun printWeather(
    city: String,
    lowTemperature: Int,
    highTemperature: Int,
    chanceOfRain: Int
) {
    println("City: $city")
    println("Low temperature: $lowTemperature, High temperature: $highTemperature")
    println("Chance of rain: $chanceOfRain%")
    println()
}