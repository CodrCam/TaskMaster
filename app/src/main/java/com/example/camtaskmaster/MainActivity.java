package com.example.camtaskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> tasks = new ArrayList<>();  // List to hold tasks
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String newTask = data.getStringExtra("newTask");
                        tasks.add(newTask);

                        LinearLayout linearLayoutTasks = findViewById(R.id.linearLayoutTasks);
                        linearLayoutTasks.removeAllViews(); // clear all tasks

                        for (String task : tasks) {
                            TextView textViewTask = new TextView(MainActivity.this);
                            textViewTask.setText(task);
                            textViewTask.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                            textViewTask.setOnClickListener(view -> {
                                // replace with intent to start Task Detail activity when ready
                                Toast.makeText(MainActivity.this, "Task clicked", Toast.LENGTH_SHORT).show();
                            });

                            linearLayoutTasks.addView(textViewTask);
                        }
                    }
                }
        );

        Button buttonAddTask = findViewById(R.id.buttonAddTask);
        buttonAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            activityResultLauncher.launch(intent);
        });

        Button buttonSettings = findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAllTasks = findViewById(R.id.buttonAllTasks);
        buttonAllTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "All Tasks clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
