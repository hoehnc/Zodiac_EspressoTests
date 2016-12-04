package com.example.chris.messengerapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Zodiac_Scorpio_Back_Leo {

    @Rule
    public ActivityTestRule<Messenger> mActivityTestRule = new ActivityTestRule<>(Messenger.class);

    @Test
    public void zodiac_Scorpio_Back_Leo() {
        ViewInteraction appCompatTextView = onView(
                allOf(withId(android.R.id.text1), withText("Scorpio"),
                        childAtPosition(
                                withId(R.id.lvStarSigns),
                                7),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.message), withText("Scorpio"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Scorpio")));

        pressBack();

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(android.R.id.text1), withText("Leo"),
                        childAtPosition(
                                withId(R.id.lvStarSigns),
                                4),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.message), withText("Leo"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Leo")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.month), withText("July 32 - August 22"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("July 32 - August 22")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
