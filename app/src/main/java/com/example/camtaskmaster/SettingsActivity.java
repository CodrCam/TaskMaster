package com.example.camtaskmaster;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences sharedPref = getSharedPreferences("appSettings", MODE_PRIVATE);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        String username = sharedPref.getString("username", "");
        if (username != null) {
            editTextUsername.setText(username);
        }

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(v -> {
            String newUsername = editTextUsername.getText().toString();
            if (newUsername.isEmpty()) {
                Toast.makeText(SettingsActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", newUsername);
            editor.apply();
            finish();
        });
    }
}
