package com.taskApp.taskmaster;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddTaskFlowIntegrationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void addTaskFlowIntegrationTest() {
        onView(allOf(withId(R.id.buttonAddTask), withText("Add Task"), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.editTextTask), isDisplayed())).perform(replaceText("New Task"), closeSoftKeyboard());

        onView(allOf(withId(R.id.editTextTaskDetail), isDisplayed())).perform(replaceText("Task Detail"), closeSoftKeyboard());

        onView(allOf(withId(R.id.buttonSubmit), withText("Submit"), isDisplayed())).perform(click());

    }
}
