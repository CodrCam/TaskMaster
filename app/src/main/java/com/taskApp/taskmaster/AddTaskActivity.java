package com.taskApp.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.camtaskmaster.R;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(v -> {
            EditText editTextTask = findViewById(R.id.editTextTask);
            String newTask = editTextTask.getText().toString();

            EditText editTextTaskDetail = findViewById(R.id.editTextTaskDetail);
            String newTaskDetail = editTextTaskDetail.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("newTask", newTask);
            intent.putExtra("newTaskDetail", newTaskDetail);
            setResult(RESULT_OK, intent);

            finish();
        });
    }
}