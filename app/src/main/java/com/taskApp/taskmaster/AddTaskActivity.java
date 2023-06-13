package com.taskApp.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;
import com.amplifyframework.datastore.generated.model.Team;
import com.taskApp.camtaskmaster.R;

import java.util.ArrayList;
import java.util.List;


public class AddTaskActivity extends AppCompatActivity {

    private Spinner teamSpinner;
    private List<Team> teams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        teamSpinner = findViewById(R.id.teamSpinner);

        // Fetch the teams from Amplify
        Amplify.DataStore.query(Team.class,
                teams -> {
                    while (teams.hasNext()) {
                        Team team = teams.next();
                        this.teams.add(team);
                    }
                    // This will run on a background thread, so to update UI elements like a Spinner,
                    // you'd need to switch to the UI thread.
                    runOnUiThread(() -> {
                        List<String> teamNames = getTeamNames(this.teams);
                        ArrayAdapter<String> teamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, teamNames);
                        teamSpinner.setAdapter(teamsAdapter);
                    });
                },
                failure -> System.out.println("Failed to fetch teams.")
        );

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(v -> {
            EditText editTextTask = findViewById(R.id.editTextTask);
            String newTask = editTextTask.getText().toString();

            EditText editTextTaskDetail = findViewById(R.id.editTextTaskDetail);
            String newTaskDetail = editTextTaskDetail.getText().toString();

            // Get the selected team name
            String selectedTeamName = (String) teamSpinner.getSelectedItem();

            // Find the Team object associated with the selected team name
            Team selectedTeam = null;
            for (Team team : teams) {
                if (team.getName().equals(selectedTeamName)) {
                    selectedTeam = team;
                    break;
                }
            }

            // Associate the task with the selected team
            Task task = Task.builder()
                    .title(newTask)
                    .details(newTaskDetail)
                    .team(selectedTeam)
                    .build();

            // Save the task
            Amplify.DataStore.save(task,
                    success -> System.out.println("Saved item: " + task.getTitle()),
                    error -> {
                        System.out.println("Could not save item to DataStore: " + error);
                        error.printStackTrace();
                    }
            );

            Intent intent = new Intent();
            intent.putExtra("newTask", newTask);
            intent.putExtra("newTaskDetail", newTaskDetail);
            setResult(RESULT_OK, intent);

            finish();
        });
    }

    private List<String> getTeamNames(List<Team> teams) {
        List<String> teamNames = new ArrayList<>();
        for (Team team : teams) {
            teamNames.add(team.getName());
        }
        return teamNames;
    }
}
