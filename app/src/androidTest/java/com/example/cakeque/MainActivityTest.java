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

public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void testIntentOrder(){
        onView(withId(R.id.OrderBtn)).perform(click());
        intended(hasComponent(OrderDashboard.class.getName()));
    }
}