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

public class proposal_dashboardTest {


    @Rule
    public IntentsTestRule<proposal_dashboard> intentsTestRule = new IntentsTestRule<>(proposal_dashboard.class);


    @Test
    public void testIntent(){
        onView(withId(R.id.button9)).perform(click());
        intended(hasComponent(create_proposal.class.getName()));
    }

    @Test
    public void testIntent1(){
        onView(withId(R.id.cakebtn)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
    }


    @Test
    public void testIntent3(){
        onView(withId(R.id.modify_btn)).perform(click());
        intended(hasComponent(ViewCakeActivity.class.getName()));
    }


    @Test
    public void testIntent4(){
        onView(withId(R.id.button_profit)).perform(click());
        intended(hasComponent(profitcalculator.class.getName()));
    }

}