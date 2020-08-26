package com.example.profileunittesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityUITest {
    //LAUNCH ACTIVITY BEFORE EACH TEST
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isMainActivityInView() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isFragmentContainerVisible() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main_container)).check(matches(isDisplayed()))
    }
}