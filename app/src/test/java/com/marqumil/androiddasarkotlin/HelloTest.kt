package com.marqumil.androiddasarkotlin

import org.junit.Assert
import org.junit.Test

class HelloTest {

    @Test
    fun testSayHello(){
        val result = Hello.sayHello("san")

        Assert.assertEquals("Hello san", result)
    }

}