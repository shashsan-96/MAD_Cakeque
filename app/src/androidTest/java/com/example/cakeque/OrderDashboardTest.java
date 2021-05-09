package com.example.cakeque;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class OrderDashboardTest {

    @Rule
    public IntentsTestRule<OrderDashboard> intentsTestRule = new IntentsTestRule<>(OrderDashboard.class);

    @Test
    public void testIntent1(){
        onView(withId(R.id.ViewOrdersBtn)).perform(click());
        intended(hasComponent(OrderList.class.getName()));
    }

    @Test
    public void testIntentCreateOrder(){
        onView(withId(R.id.createOrderBtn)).perform(click());
        intended(hasComponent(CreateOrder.class.getName()));
    }

    @Test
    public void testIntentModifyOrder(){
        onView(withId(R.id.modifyOrderBtn)).perform(click());
        intended(hasComponent(ModifyOrder.class.getName()));
    }

}