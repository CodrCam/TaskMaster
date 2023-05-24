package com.example.camtaskmaster;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    public TextView taskTitle;

    public TaskViewHolder(View itemView) {
        super(itemView);
        taskTitle = itemView.findViewById(R.id.textViewTask);
    }
}

