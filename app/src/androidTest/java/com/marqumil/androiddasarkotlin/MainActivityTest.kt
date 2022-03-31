package com.marqumil.androiddasarkotlin

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//
//    @Before
//    fun setUp(){
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
//
//    @Test
//    fun testBlank(){
//
//    }
//
//    @After
//    fun tearDown(){
//        mainActivityScenario.close()
//    }

    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testMainActivity() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val name = "san"

        onView(withId(R.id.nameEditTxt))
            .perform(typeText(name), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.sayHelloBtn))
            .perform(click())

        onView(withId((R.id.nameTxt)))
            .check(matches(withText(context.getString(R.string.sayHelloText, name))))

        Thread.sleep(2000)
    }
}