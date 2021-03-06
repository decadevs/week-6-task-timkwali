package com.example.profileunittesting

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
class FormFragmentUITest {
    //LAUNCH ACTIVITY
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_areFormFieldsVisible() {
        //LAUNCH FRAGMENT
        val form = launchFragmentInContainer<FormFragment>()

        //CHECK NAME FIELD
        Espresso.onView(ViewMatchers.withId(R.id.name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //CHECK PHONE FIELD
        Espresso.onView(ViewMatchers.withId(R.id.phone))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //CHECK EMAIL FIELD
        Espresso.onView(ViewMatchers.withId(R.id.email))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //CHECK SEX FIELD
        Espresso.onView(ViewMatchers.withId(R.id.sex))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //CHECK REGISTER BUTTON
        Espresso.onView(ViewMatchers.withId(R.id.register))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_goToProfileFragment_whenButtonClicked() {
        //LOAD FORM FRAGMENT
        val form = launchFragmentInContainer<FormFragment>()
        //SET FIELDS
        onView((withId(R.id.name))).perform(typeText("John Doe"))
        onView((withId(R.id.phone))).perform(typeText("08012345678"))
        onView((withId(R.id.email))).perform(typeText("example@email.com"))
        onView((withId(R.id.sex))).perform(click())
        onView(withText("Male")).perform(click());
        //CLICK REGISTER BUTTON
        onView(withId(R.id.register)).perform(click())
        //VERIFY PROFILE FRAGMENT IS SHOWN
        onView(withId(R.id.profile_fragment)).check(matches(isDisplayed()))
    }
}