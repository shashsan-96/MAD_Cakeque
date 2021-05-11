package com.example.cakeque;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


class ProfileDashboardTest {
    @Rule
    public IntentsTestRule<ProfileDashboard> intentsTestRule = new IntentsTestRule<>(ProfileDashboard.class);


    @Test
    public void testIntent(){
        onView(withId(R.id.btnCake)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
    }

    @Test
    public void testIntent1(){
        onView(withId(R.id.btncen)).perform(click());
        intended(hasComponent(CreateProfile.class.getName()));
    }


    @Test
    public void testIntent3(){
        onView(withId(R.id.btnup)).perform(click());
        intended(hasComponent(ViewProfileActivity.class.getName()));
    }




}