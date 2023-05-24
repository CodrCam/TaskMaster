package com.example.camtaskmaster;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private ArrayList<Task> tasks;
    private Context context;
    private OnTaskClickListener onTaskClickListener;

    public interface OnTaskClickListener {
        void onTaskClick(Task task);
    }

    public TaskAdapter(Context context, ArrayList<Task> tasks, OnTaskClickListener onTaskClickListener) {
        this.context = context;
        this.tasks = tasks;
        this.onTaskClickListener = onTaskClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.bind(task, onTaskClickListener);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTask;
        Button buttonMarkAsDoing, buttonMarkAsDone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            buttonMarkAsDoing = itemView.findViewById(R.id.buttonMarkAsDoing);
            buttonMarkAsDone = itemView.findViewById(R.id.buttonMarkAsDone);
        }

        public void bind(final Task task, final OnTaskClickListener listener) {
            textViewTask.setText(task.getTitle());
            buttonMarkAsDoing.setOnClickListener(view -> {
                // Update the task status to "doing"
                task.setStatus("doing");
                listener.onTaskClick(task);
            });

            buttonMarkAsDone.setOnClickListener(view -> {
                // Update the task status to "done"
                task.setStatus("done");
                listener.onTaskClick(task);
            });
        }
    }
}
