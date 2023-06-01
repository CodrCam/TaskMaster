package com.example.camtaskmaster;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private ArrayList<Task> tasks;
    private Context context;
    private OnTaskClickListener onTaskClickListener;

    public TaskAdapter(MainActivity activity, ArrayList<Task> tasks, MainActivity onTaskClickListener) {

    }

    public interface OnTaskClickListener {
        void onTaskClick(Task task);
        void onDoingClick(Task task);
        void onDoneClick(Task task);
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
        ImageView taskStatusIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            buttonMarkAsDoing = itemView.findViewById(R.id.buttonMarkAsDoing);
            buttonMarkAsDone = itemView.findViewById(R.id.buttonMarkAsDone);
            taskStatusIcon = itemView.findViewById(R.id.taskStatusIcon);
        }

        public void bind(final Task task, final OnTaskClickListener listener) {
            textViewTask.setText(task.getTitle());

            // Reset task status icon
            switch (task.getStatus()) {
                case "doing":
                    taskStatusIcon.setVisibility(View.VISIBLE);
                    taskStatusIcon.setImageResource(R.drawable.rocket_launch);
                    break;
                case "done":
                    taskStatusIcon.setVisibility(View.VISIBLE);
                    taskStatusIcon.setImageResource(R.drawable.check_circle);
                    break;
                default:
                    taskStatusIcon.setVisibility(View.GONE);
            }

            textViewTask.setOnClickListener(v -> listener.onTaskClick(task));

            buttonMarkAsDoing.setOnClickListener(view -> {
                // Update the task status to "doing"
                task.setStatus("doing");
                taskStatusIcon.setVisibility(View.VISIBLE);
                taskStatusIcon.setImageResource(R.drawable.rocket_launch);
                System.out.println("Marked as doing: " + task.getTitle());  // Logging here
                listener.onDoingClick(task);

                Amplify.DataStore.save(task,
                        success -> Log.i("TaskAdapter", "Updated task to 'doing': " + task.getTitle()),
                        error -> Log.e("TaskAdapter", "Could not update task to 'doing': " + error)
                );
            });

            buttonMarkAsDone.setOnClickListener(view -> {
                // Update the task status to "done"
                task.setStatus("done");
                taskStatusIcon.setVisibility(View.VISIBLE);
                taskStatusIcon.setImageResource(R.drawable.check_circle);
                System.out.println("Marked as done: " + task.getTitle());  // Logging here
                listener.onDoneClick(task);

                Amplify.DataStore.save(task,
                        success -> Log.i("TaskAdapter", "Updated task to 'done': " + task.getTitle()),
                        error -> Log.e("TaskAdapter", "Could not update task to 'done': " + error)
                );
            });

        }



    }
}

