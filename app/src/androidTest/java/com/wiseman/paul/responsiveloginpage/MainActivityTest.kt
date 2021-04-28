package com.wiseman.paul.responsiveloginpage


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.CoreMatchers.containsString
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    /**
     * ...UI test for the first activity(main activity)
     * ...the test checks for the visibilty/display of the views present in the login page
     */

    companion object{
        var name = "Paul"
        var phoneNumber = "09015525620"
        var email = "paulndibe92@gmail.com"
        var gender = "Male"

    }
    @Test
    fun test_isMainActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun is_login_page_textLogo_visible() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.login_page_textLogo)).check(matches(isDisplayed()))
        onView(withId(R.id.login_page_textLogo)).check(matches(withText(R.string.Login_Page_Text)))
    }

    @Test
    fun `is_login_page_userName_Edittext_visible`() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.login_page_userName)).check(matches(isDisplayed()))
    }

    @Test
    fun `is_login_page_phoneNumber_Edittext_visible`() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.login_page_phoneNumber)).check(matches(isDisplayed()))
    }

    @Test
    fun `is_login_page_Email_Edittext_visible`() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.login_page_Email)).check(matches(isDisplayed()))
    }

    @Test
    fun `is_login_page_gender_Edittext_visible`() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.login_page_gender)).check(matches(isDisplayed()))
    }

    @Test
    fun `is_login_page_Register_Button_visible`() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btnRegister)).check(matches(isDisplayed()))
        onView(withId(R.id.login_page_userName)).perform(replaceText(name))
        onView(withId(R.id.login_page_phoneNumber)).perform(replaceText(phoneNumber))
        onView(withId(R.id.login_page_Email)).perform(replaceText(email))
        onView(withId(R.id.login_page_gender)).perform(click())
        onData(anything()).atPosition(0).perform(click())
        onView(withId(R.id.login_page_gender)).check(matches(withSpinnerText(containsString(gender))))
        onView(withId(R.id.btnRegister)).perform(click())

        onView(withId(R.id.profile_activity)).check(matches(isDisplayed()))

        onView(withId(R.id.profile_page_userName)).check(matches(withText(name)))

        onView(withId(R.id.profile_page_phoneNumber)).check(matches(withText(phoneNumber)))
        onView(withId(R.id.profile_page_Email)).check(matches(withText(email)))
        onView(withId(R.id.profile_page_gender)).check(matches(withText(gender)))


    }

    @Test
    fun `is_login_page_Already_Have_an_Account_TextView_visible`() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.alreadyHaveAccount)).check(matches(isDisplayed()))
        onView(withId(R.id.alreadyHaveAccount)).check(matches(withText(R.string.Already_Have_an_Account_Text)))
    }

    /**
     * ...UI test for the second activity(profile activity)
     * ...the test checks for the visibilty/display of the views present in the login page
     */
    @Test
    fun test_isprofileActivityInView() {
        val activityScenario = ActivityScenario.launch(ProfileActivity::class.java)
        onView(withId(R.id.profile_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun `is_profile_page_textLogo_TextView_visible`() {
        val activityScenario = ActivityScenario.launch(ProfileActivity::class.java)
        onView(withId(R.id.profile_page_textLogo)).check(matches(isDisplayed()))
    }


    @Test
    fun `is_profile_page_userName_TextView_visible`() {
        val activityScenario = ActivityScenario.launch(ProfileActivity::class.java)
        onView(withId(R.id.profile_page_userName)).check(matches(isDisplayed()))
    }

    @Test
    fun `is_profile_page_phoneNumber_TextView_visible`() {
        val activityScenario = ActivityScenario.launch(ProfileActivity::class.java)
        onView(withId(R.id.profile_page_phoneNumber)).check(matches(isDisplayed()))
    }

    @Test
    fun `is_profile_page_Email_TextView_visible`() {
        val activityScenario = ActivityScenario.launch(ProfileActivity::class.java)
        onView(withId(R.id.profile_page_Email)).check(matches(isDisplayed()))
    }

    @Test
    fun `is_profile_page_gender_TextView_visible`() {
        val activityScenario = ActivityScenario.launch(ProfileActivity::class.java)
        onView(withId(R.id.profile_page_gender)).check(matches(isDisplayed()))
    }
}