package com.example.camtaskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        Intent intent = getIntent();
        String taskTitle = intent.getStringExtra("taskTitle");
        String taskDetail = intent.getStringExtra("taskDetail");

        TextView textViewTitle = findViewById(R.id.textViewTitle);
        textViewTitle.setText(taskTitle);

        TextView textViewDetail = findViewById(R.id.textViewDetail);
        textViewDetail.setText(taskDetail);
    }
}
