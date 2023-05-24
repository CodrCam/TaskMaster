package com.example.camtaskmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<>();  // List to hold tasks
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the value to activityResultLauncher
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent data = result.getData();
                    if (data != null) {
                        String newTask = data.getStringExtra("newTask");
                        String newTaskDetail = data.getStringExtra("newTaskDetail");
                        tasks.add(new Task(newTask, newTaskDetail));

                        displayTasks();
                    }

                }
        );

        Button buttonAddTask = findViewById(R.id.buttonAddTask);
        buttonAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            activityResultLauncher.launch(intent);
        });

        ImageView buttonSettings = findViewById(R.id.menu_manage);
        buttonSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        displayTasks();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPref = getSharedPreferences("appSettings", MODE_PRIVATE);
        String username = sharedPref.getString("username", "");

        TextView textViewTitle = findViewById(R.id.textViewTitle);
        textViewTitle.setText(getString(R.string.task_title, username));

        displayTasks();
    }

    private void displayTasks() {
        LinearLayout linearLayoutTasks = findViewById(R.id.linearLayoutTasks);
        linearLayoutTasks.removeAllViews(); // clear all tasks

        for (Task task : tasks) {
            TextView textViewTask = new TextView(MainActivity.this);
            textViewTask.setText(task.getTitle());
            textViewTask.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            textViewTask.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
                intent.putExtra("taskTitle", task.getTitle());
                intent.putExtra("taskDetail", task.getDetails()); // corrected here
                startActivity(intent);
            });

            linearLayoutTasks.addView(textViewTask);
        }
    }
}