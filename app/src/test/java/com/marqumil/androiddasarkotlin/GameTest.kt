package com.marqumil.androiddasarkotlin

import org.junit.Assert
import org.junit.Test

class GameTest {
    @Test
    fun testPickRandomOption(){
        val options = listOf("ROCK", "PAPER", "SCISSORS")

        Assert.assertTrue(options.contains(Game.pickRandom()))
        Assert.assertTrue(options.contains(Game.pickRandom()))
        Assert.assertTrue(options.contains(Game.pickRandom()))
        Assert.assertTrue(options.contains(Game.pickRandom()))
        Assert.assertTrue(options.contains(Game.pickRandom()))
        Assert.assertTrue(options.contains(Game.pickRandom()))
    }

    @Test
    fun testPickDrawable(){
        Assert.assertEquals(R.drawable.paper, Game.pickDrawable("PAPER"))
        Assert.assertEquals(R.drawable.scisssors, Game.pickDrawable("SCISSORS"))
        Assert.assertEquals(R.drawable.rock, Game.pickDrawable("ROCK"))
    }

    @Test
    fun testIsDraw(){
        Assert.assertTrue(Game.isDraw("ROCK", "ROCK"))
        Assert.assertTrue(Game.isDraw("SCISSORS", "SCISSORS"))
        Assert.assertTrue(Game.isDraw("PAPER", "PAPER"))

        Assert.assertFalse(Game.isDraw("SCISSORS", "ROCK"))
        Assert.assertFalse(Game.isDraw("PAPER", "SCISSORS"))
        Assert.assertFalse(Game.isDraw("ROCK", "PAPER"))
    }

    @Test
    fun testWin(){
        Assert.assertTrue(Game.iswin("PAPER", "ROCK"))
        Assert.assertTrue(Game.iswin("ROCK", "SCISSORS"))
        Assert.assertTrue(Game.iswin("SCISSORS", "PAPER"))

        Assert.assertFalse(Game.iswin("ROCK", "PAPER"))
        Assert.assertFalse(Game.iswin("SCISSORS", "ROCK"))
        Assert.assertFalse(Game.iswin("PAPER", "SCISSORS"))
    }
}