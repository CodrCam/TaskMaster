package com.example.camtaskmaster;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    public TextView taskTitle;
    Button buttonMarkAsDoing, buttonMarkAsDone;
    ImageView taskStatusIcon;
    TextView textViewTask;

    public TaskViewHolder(View itemView) {
        super(itemView);
        textViewTask = itemView.findViewById(R.id.textViewTask);
        buttonMarkAsDoing = itemView.findViewById(R.id.buttonMarkAsDoing);
        buttonMarkAsDone = itemView.findViewById(R.id.buttonMarkAsDone);
        taskStatusIcon = itemView.findViewById(R.id.taskStatusIcon);
    }
}

