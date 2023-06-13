package com.taskApp.taskmaster;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.taskApp.camtaskmaster.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class)
public class AddTaskActivityTest {
    @Rule
    public ActivityScenarioRule<AddTaskActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AddTaskActivity.class);

    @Test
    public void selectTeamFromSpinner() {
        String teamNameToSelect = "Seahawks";

        onView(withId(R.id.teamSpinner)).perform(click());
        onView(withSpinnerText(containsString(teamNameToSelect))).perform(click());

        onView(withId(R.id.teamSpinner)).check(ViewAssertions.matches(withSpinnerText(containsString(teamNameToSelect))));
    }

}

