package com.example.camtaskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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

                        TextView textViewTasks = findViewById(R.id.textViewTasks);
                        textViewTasks.setText(TextUtils.join("\n", tasks));
                    }
                }
        );

        Button buttonAddTask = findViewById(R.id.buttonAddTask);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                activityResultLauncher.launch(intent);
            }
        });

        Button buttonRemoveTask = findViewById(R.id.buttonRemoveTask);
        buttonRemoveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tasks.isEmpty()) {
                    tasks.remove(tasks.size() - 1);

                    TextView textViewTasks = findViewById(R.id.textViewTasks);
                    textViewTasks.setText(TextUtils.join("\n", tasks));
                } else {
                    Toast.makeText(MainActivity.this, "No tasks to remove", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonAllTasks = findViewById(R.id.buttonAllTasks);
        buttonAllTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace with intent to start All Tasks activity when ready
                Toast.makeText(MainActivity.this, "All Tasks clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
