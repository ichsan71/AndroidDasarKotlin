package com.marqumil.androiddasarkotlin

import kotlin.random.Random

object Game {

    val rules = mapOf(
        "ROCK-SCISSORS" to true,
        "ROCK-PAPER" to false,
        "PAPER-SCISSORS" to false,
        "PAPER-ROCK" to true,
        "SCISSORS-PAPER" to true,
        "SCISSORS-ROCK" to false
    )

    val options = listOf("ROCK", "SCISSORS", "PAPER")

    private val optionalDrawable = mapOf(
        "ROCK" to R.drawable.rock,
        "SCISSORS" to R.drawable.scisssors,
        "PAPER" to R.drawable.paper
    )

    fun pickRandom(): String = options[Random.nextInt(0, 3)]

    fun pickDrawable(option: String): Int = optionalDrawable[option]!!

    fun isDraw(player: String, comp: String): Boolean = player == comp

    fun iswin(player: String, comp: String): Boolean = rules["$player-$comp"]!!

}