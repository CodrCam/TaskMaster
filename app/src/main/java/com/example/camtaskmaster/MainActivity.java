package com.example.camtaskmaster;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnTaskClickListener {

    ArrayList<Task> tasks = new ArrayList<>();  // List to hold tasks
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView taskRecyclerView = findViewById(R.id.taskRecyclerView);

        // Assign the value to activityResultLauncher
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String newTask = data.getStringExtra("newTask");
                            String newTaskDetail = data.getStringExtra("newTaskDetail");

                            Task task = Task.builder()
                                    .title(newTask)
                                    .details(newTaskDetail)
                                    .build();

                            Amplify.DataStore.save(task,
                                    success -> {
                                        runOnUiThread(() -> {
                                            tasks.add(task);
                                            taskAdapter.notifyDataSetChanged();
                                        });
                                        System.out.println("Saved item: " + task.getTitle());
                                    },
                                    error -> {
                                        System.out.println("Could not save item to DataStore: " + error);
                                        error.printStackTrace();
                                    }
                            );


                        }
                    }
                }
        );

        taskAdapter = new TaskAdapter(this, tasks, this);
        taskRecyclerView.setAdapter(taskAdapter);

        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPref = getSharedPreferences("appSettings", MODE_PRIVATE);
        String username = sharedPref.getString("username", "");

        TextView textViewTitle = findViewById(R.id.textViewTitle);
        textViewTitle.setText(getString(R.string.task_title, username));
    }

    @Override
    public void onTaskClick(com.amplifyframework.datastore.generated.model.Task task) {
        Intent intent = new Intent(this, TaskDetailActivity.class);
        intent.putExtra("taskTitle", task.getTitle());
        intent.putExtra("taskDetail", task.getDetails());
        intent.putExtra("taskStatus", task.getStatus());
        startActivity(intent);
    }

    @Override
    public void onDoingClick(com.amplifyframework.datastore.generated.model.Task task) {
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDoneClick(com.amplifyframework.datastore.generated.model.Task task) {
        taskAdapter.notifyDataSetChanged();
    }
}
