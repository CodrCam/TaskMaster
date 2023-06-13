package com.taskApp.taskmaster;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.taskApp.camtaskmaster.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SaveUserNicknameFlowIntegrationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void saveUserNicknameFlowIntegrationTest() {
        onView(allOf(withId(R.id.menu_manage), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.editTextUsername), isDisplayed())).perform(replaceText("rey"), closeSoftKeyboard());

        onView(allOf(withId(R.id.buttonSave), withText("Save"), isDisplayed())).perform(click());

        pressBack();

        onView(allOf(withId(R.id.textViewTitle), isDisplayed())).check(matches(withText("Tasks for rey")));
    }
}