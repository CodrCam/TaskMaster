package com.taskApp.taskmaster;

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
import com.taskApp.camtaskmaster.R;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private ArrayList<Task> tasks;
    private OnTaskClickListener onTaskClickListener;

    public interface OnTaskClickListener {
        void onTaskClick(Task task);
        void onDoingClick(Task task);
        void onDoneClick(Task task);
    }

    public TaskAdapter(Context context, ArrayList<Task> tasks, OnTaskClickListener onTaskClickListener) {
        this.tasks = tasks;
        this.onTaskClickListener = onTaskClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.bind(task, onTaskClickListener, position);
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

        public void bind(final Task task, final OnTaskClickListener listener, final int position) {
            textViewTask.setText(task.getTitle());

            String status = task.getStatus();
            if (status != null) {
                switch (status) {
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
            } else {
                taskStatusIcon.setVisibility(View.GONE);
            }

            textViewTask.setOnClickListener(v -> listener.onTaskClick(task));

            buttonMarkAsDoing.setOnClickListener(view -> {
                Task updatedTask = task.copyOfBuilder().status("doing").build();
                tasks.set(position, updatedTask);
                taskStatusIcon.setVisibility(View.VISIBLE);
                taskStatusIcon.setImageResource(R.drawable.rocket_launch);
                Log.i("TaskAdapter", "Marked as doing: " + updatedTask.getTitle());
                listener.onDoingClick(updatedTask);

                Amplify.DataStore.save(updatedTask,
                        success -> {
                            Log.i("TaskAdapter", "Updated task to 'doing': " + updatedTask.getTitle());
                            notifyItemChanged(position);
                        },
                        error -> Log.e("TaskAdapter", "Could not update task to 'doing': " + error)
                );
            });

            buttonMarkAsDone.setOnClickListener(view -> {
                Task updatedTask = task.copyOfBuilder().status("done").build();
                tasks.set(position, updatedTask);
                taskStatusIcon.setVisibility(View.VISIBLE);
                taskStatusIcon.setImageResource(R.drawable.check_circle);
                Log.i("TaskAdapter", "Marked as done: " + updatedTask.getTitle());
                listener.onDoneClick(updatedTask);

                Amplify.DataStore.save(updatedTask,
                        success -> {
                            Log.i("TaskAdapter", "Updated task to 'done': " + updatedTask.getTitle());
                            notifyItemChanged(position);
                        },
                        error -> Log.e("TaskAdapter", "Could not update task to 'done': " + error)
                );
            });
        }
    }
}
