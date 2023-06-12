package com.taskApp.taskmaster;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.taskApp.camtaskmaster.R;


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

