package com.taskApp.taskmaster;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Team;
import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.taskApp.camtaskmaster.R;


import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class SettingsActivity extends AppCompatActivity {
    private Spinner teamSpinner;
    private List<Team> teams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences sharedPref = getSharedPreferences("appSettings", MODE_PRIVATE);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        String username = sharedPref.getString("username", "");
        editTextUsername.setText(username);

        teamSpinner = findViewById(R.id.teamSpinner);

        // Define the team names
        String[] teamNames = {"Seahawks", "4whiners", "Lambs", "Baseball"};

        // Create teams and add them to the list
        for (String teamName : teamNames) {
            Team team = Team.builder()
                    .name(teamName)
                    .build();

            teams.add(team);
        }

        // Set teams to spinner
        ArrayAdapter<String> teamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, teamNames);
        teamSpinner.setAdapter(teamsAdapter);

        // Save each team
        for (Team team : teams) {
            Amplify.DataStore.save(team,
                    success -> Log.i("Tutorial", "Saved item: " + success.item().getName()),
                    error -> Log.e("Tutorial", "Could not save item to DataStore", error)
            );
        }

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(v -> {
            String newUsername = editTextUsername.getText().toString();
            if (newUsername.isEmpty()) {
                Toast.makeText(SettingsActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            String selectedTeam = teamSpinner.getSelectedItem().toString();
            if (selectedTeam.isEmpty()) {
                Toast.makeText(SettingsActivity.this, "Please select a team", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", newUsername);
            editor.putString("team", selectedTeam);
            editor.apply();
            finish();
        });
    }


}
