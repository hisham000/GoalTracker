package com.example.goaltracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Task_RecyclerViewAdapter extends RecyclerView.Adapter<Task_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<TasksModel> tasksModels;

    public Task_RecyclerViewAdapter(Context context, ArrayList<TasksModel> taskmodels){
        this.context = context;
        this.tasksModels=taskmodels;
    }
    @NonNull
    @Override
    public Task_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row_tasks, parent, false);
        return new Task_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Task_RecyclerViewAdapter.MyViewHolder holder, int position) {
    holder.TVtaskname.setText(tasksModels.get(position).getTaskName());
    holder.TVduedate.setText(tasksModels.get(position).getDueDate());
    holder.IVcolor.setImageResource(tasksModels.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return tasksModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView IVcolor;
        TextView TVtaskname, TVduedate;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            IVcolor = itemView.findViewById(R.id.TVduedate);
            TVtaskname = itemView.findViewById(R.id.TVtaskname);
            TVduedate = itemView.findViewById(R.id.TVduedate);

        }
    }
}
