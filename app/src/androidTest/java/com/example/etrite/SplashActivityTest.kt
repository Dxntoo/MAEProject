package com.example.etrite


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SplashActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SplashActivity::class.java)

    @Test
    fun splashActivityTest() {
        val materialTextView = onView(
allOf(withId(R.id.forgotPasswordText), withText("Forgot Password?"),
childAtPosition(
allOf(withId(R.id.logo),
childAtPosition(
withId(android.R.id.content),
0)),
5),
isDisplayed()))
        materialTextView.perform(click())
        
        val mSPEditText = onView(
allOf(withId(R.id.emailresetText),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        mSPEditText.perform(replaceText("danishzwordan@gmail.com"), closeSoftKeyboard())
        
        val mSPButton = onView(
allOf(withId(R.id.forgotPasswordBtn), withText("Submit"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()))
        mSPButton.perform(click())
        
        val mSPButton2 = onView(
allOf(withId(R.id.signupBtn), withText("Sign Up"),
childAtPosition(
allOf(withId(R.id.logo),
childAtPosition(
withId(android.R.id.content),
0)),
4),
isDisplayed()))
        mSPButton2.perform(click())
        
        val mSPEditText2 = onView(
allOf(withId(R.id.usernameText),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
6),
isDisplayed()))
        mSPEditText2.perform(replaceText("giornogiovanna"), closeSoftKeyboard())
        
        val mSPEditText3 = onView(
allOf(withId(R.id.emailText),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()))
        mSPEditText3.perform(replaceText("giornogiovannabruh@protonmail.com"), closeSoftKeyboard())
        
        val mSPEditText4 = onView(
allOf(withId(R.id.passwordText),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        mSPEditText4.perform(replaceText("qwerty123"), closeSoftKeyboard())
        
        val mSPEditText5 = onView(
allOf(withId(R.id.confirmPasswordText),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
5),
isDisplayed()))
        mSPEditText5.perform(replaceText("qwerty123"), closeSoftKeyboard())
        
        val appCompatCheckBox = onView(
allOf(withId(R.id.cb_terms_and_condition),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()))
        appCompatCheckBox.perform(click())
        
        val mSPButton3 = onView(
allOf(withId(R.id.registerBtn), withText("Register"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()))
        mSPButton3.perform(click())
        
        val mSPEditText6 = onView(
allOf(withId(R.id.emailTextField),
childAtPosition(
allOf(withId(R.id.logo),
childAtPosition(
withId(android.R.id.content),
0)),
0),
isDisplayed()))
        mSPEditText6.perform(replaceText("danishzwordan@gmail.com"), closeSoftKeyboard())
        
        val mSPEditText7 = onView(
allOf(withId(R.id.passwordTextField),
childAtPosition(
allOf(withId(R.id.logo),
childAtPosition(
withId(android.R.id.content),
0)),
1),
isDisplayed()))
        mSPEditText7.perform(replaceText("dantoo123"), closeSoftKeyboard())
        
        val mSPButton4 = onView(
allOf(withId(R.id.loginBtn), withText("Login"),
childAtPosition(
allOf(withId(R.id.logo),
childAtPosition(
withId(android.R.id.content),
0)),
2),
isDisplayed()))
        mSPButton4.perform(click())
        
        val bottomNavigationItemView = onView(
allOf(withId(R.id.navigation_exercise), withContentDescription("Exercise"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
1),
isDisplayed()))
        bottomNavigationItemView.perform(click())
        
        val appCompatImageView = onView(
allOf(withId(R.id.recommendedImage),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.ScrollView")),
0),
2)))
        appCompatImageView.perform(scrollTo(), click())
        
        pressBack()
        
        val appCompatImageView2 = onView(
allOf(withId(R.id.recommendedImage),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.ScrollView")),
0),
2)))
        appCompatImageView2.perform(scrollTo(), click())
        
        pressBack()
        
        val appCompatImageView3 = onView(
allOf(withId(R.id.recommendedImage),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.ScrollView")),
0),
2)))
        appCompatImageView3.perform(scrollTo(), click())
        
        val appCompatImageView4 = onView(
allOf(withId(R.id.recommendedImage),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.ScrollView")),
0),
2)))
        appCompatImageView4.perform(scrollTo(), click())
        
        pressBack()
        
        pressBack()
        
        val appCompatImageView5 = onView(
allOf(withId(R.id.recipeImage),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.ScrollView")),
0),
11)))
        appCompatImageView5.perform(scrollTo(), click())
        
        pressBack()
        
        val bottomNavigationItemView2 = onView(
allOf(withId(R.id.navigation_dashboard), withContentDescription("Dashboard"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
2),
isDisplayed()))
        bottomNavigationItemView2.perform(click())
        
        val toolbar = onView(
allOf(withId(R.id.foodItemBar),
childAtPosition(
childAtPosition(
withId(R.id.fragmentContainerView4),
0),
0)))
        toolbar.perform(scrollTo(), click())
        
        val mSPButton5 = onView(
allOf(withId(R.id.addFoodBtn), withText("Add"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
14),
isDisplayed()))
        mSPButton5.perform(click())
        
        val materialButton = onView(
allOf(withId(android.R.id.button1), withText("YES"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.ScrollView")),
0),
3)))
        materialButton.perform(scrollTo(), click())
        
        pressBack()
        
        val toolbar2 = onView(
allOf(withId(R.id.foodItemBar),
childAtPosition(
childAtPosition(
withId(R.id.fragmentContainerView6),
0),
0)))
        toolbar2.perform(scrollTo(), click())
        
        val mSPButton6 = onView(
allOf(withId(R.id.cancelBtn), withText("cancel"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
13),
isDisplayed()))
        mSPButton6.perform(click())
        
        pressBack()
        
        val mSPButton7 = onView(
allOf(withId(R.id.addNewMealBtn), withText("Add New Meal"),
childAtPosition(
childAtPosition(
withId(R.id.nav_host_fragment_activity_dashboard),
0),
5),
isDisplayed()))
        mSPButton7.perform(click())
        
        val toolbar3 = onView(
allOf(withId(R.id.foodItemBar),
childAtPosition(
childAtPosition(
withId(R.id.foodContainer),
0),
0),
isDisplayed()))
        toolbar3.perform(click())
        
        val mSPButton8 = onView(
allOf(withId(R.id.addFoodBtn), withText("Add"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
14),
isDisplayed()))
        mSPButton8.perform(click())
        
        val materialButton2 = onView(
allOf(withId(android.R.id.button1), withText("YES"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.ScrollView")),
0),
3)))
        materialButton2.perform(scrollTo(), click())
        
        pressBack()
        
        pressBack()
        
        val bottomNavigationItemView3 = onView(
allOf(withId(R.id.navigation_chatroom), withContentDescription("Chatroom"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
3),
isDisplayed()))
        bottomNavigationItemView3.perform(click())
        
        val appCompatImageView6 = onView(
allOf(withId(R.id.chatroomBar),
childAtPosition(
childAtPosition(
withId(R.id.fragmentContainerView22),
0),
0)))
        appCompatImageView6.perform(scrollTo(), click())
        
        val mSPEditText8 = onView(
allOf(withId(R.id.chatroomTextField),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()))
        mSPEditText8.perform(replaceText("test"), closeSoftKeyboard())
        
        val mSPEditText9 = onView(
allOf(withId(R.id.chatroomTextField), withText("test"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()))
        mSPEditText9.perform(pressImeActionButton())
        
        pressBack()
        
        val bottomNavigationItemView4 = onView(
allOf(withId(R.id.navigation_profile), withContentDescription("Profile"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
4),
isDisplayed()))
        bottomNavigationItemView4.perform(click())
        
        val appCompatImageView7 = onView(
allOf(withId(R.id.profilePicture), withContentDescription("Avatar"),
childAtPosition(
childAtPosition(
withId(R.id.nav_host_fragment_activity_dashboard),
0),
1),
isDisplayed()))
        appCompatImageView7.perform(click())
        
        val mSPButton9 = onView(
allOf(withId(R.id.editProfileBtn), withText("Edit"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
7),
isDisplayed()))
        mSPButton9.perform(click())
        
        val mSPEditText10 = onView(
allOf(withId(R.id.usernameTextField), withText("dantooine"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
6),
isDisplayed()))
        mSPEditText10.perform(replaceText("dantooin"))
        
        val mSPEditText11 = onView(
allOf(withId(R.id.usernameTextField), withText("dantooin"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
6),
isDisplayed()))
        mSPEditText11.perform(closeSoftKeyboard())
        
        val mSPButton10 = onView(
allOf(withId(R.id.saveBtn), withText("save changes"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
5),
isDisplayed()))
        mSPButton10.perform(click())
        
        val bottomNavigationItemView5 = onView(
allOf(withId(R.id.navigation_profile), withContentDescription("Profile"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
4),
isDisplayed()))
        bottomNavigationItemView5.perform(click())
        
        val appCompatImageView8 = onView(
allOf(withId(R.id.profilePicture), withContentDescription("Avatar"),
childAtPosition(
childAtPosition(
withId(R.id.nav_host_fragment_activity_dashboard),
0),
1),
isDisplayed()))
        appCompatImageView8.perform(click())
        
        pressBack()
        
        val appCompatImageView9 = onView(
allOf(withId(R.id.profilePicture), withContentDescription("Avatar"),
childAtPosition(
childAtPosition(
withId(R.id.nav_host_fragment_activity_dashboard),
0),
1),
isDisplayed()))
        appCompatImageView9.perform(click())
        
        val mSPButton11 = onView(
allOf(withId(R.id.saveBtn), withText("Logout"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()))
        mSPButton11.perform(click())
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
