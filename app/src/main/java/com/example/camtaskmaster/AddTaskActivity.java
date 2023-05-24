package com.example.camtaskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextTask = findViewById(R.id.editTextTask);
                String newTask = editTextTask.getText().toString();

                EditText editTextTaskDetail = findViewById(R.id.editTextTaskDetail);
                String newTaskDetail = editTextTaskDetail.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("newTask", newTask);
                intent.putExtra("newTaskDetail", newTaskDetail);
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}