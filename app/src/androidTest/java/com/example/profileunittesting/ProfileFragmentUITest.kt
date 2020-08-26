package com.example.profileunittesting

import org.junit.Assert.*
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.EnumSet.allOf


@RunWith(AndroidJUnit4ClassRunner::class)
class ProfileFragmentUITest {
    //LAUNCH ACTIVITY
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    fun test_areFormFieldsVisible() {
        //LAUNCH FRAGMENT
        val form = launchFragmentInContainer<ProfileFragment>()

        //CHECK NAME FIELD
        Espresso.onView(ViewMatchers.withId(R.id.name_field))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //CHECK PHONE FIELD
        Espresso.onView(ViewMatchers.withId(R.id.phone_field))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //CHECK EMAIL FIELD
        Espresso.onView(ViewMatchers.withId(R.id.email_field))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //CHECK SEX FIELD
        Espresso.onView(ViewMatchers.withId(R.id.sex_field))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}