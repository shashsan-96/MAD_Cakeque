package com.example.cakeque;

import androidx.test.espresso.intent.rule.IntentsTestRule;

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
    public void testIntent(){
        onView(withId(R.id.h_propobtn)).perform(click());
        intended(hasComponent(proposal_dashboard.class.getName()));
    }

    @Test
    public void testIntent1(){
        onView(withId(R.id.button2)).perform(click());
        intended(hasComponent(OrderDashboard.class.getName()));
    }


}

