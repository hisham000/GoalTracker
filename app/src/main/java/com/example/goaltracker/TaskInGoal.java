package com.example.goaltracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TaskInGoal extends AppCompatActivity {
    ArrayList<TasksModel> taskmodels = new ArrayList<>();//this list will hold all our tasks and send them later to our recyclerview adapter
   // int[] colorimages = {R.drawable.}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_in_goal);
        RecyclerView RVtasks = findViewById(R.id.RVtasks);

        setUpTaskModels();

        Task_RecyclerViewAdapter adapter = new Task_RecyclerViewAdapter(this, taskmodels);
        RVtasks.setAdapter(adapter);
        RVtasks.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setUpTaskModels(){
        ArrayList<String> taskNames = null;
        ArrayList<String> taskDiscs;
        ArrayList<String> taskDueDates;
        ArrayList<String> taskImportance;
        ArrayList<TasksModel> taskPreReq;
        ArrayList<Integer> taskColor;
        //get these from database later on
        //create a model of each of the tasks and store list above:
        for(int i =0; i<taskNames.size();i++){
           // taskmodels.add(new TasksModel(//pass them in by index))
            
        }
    }
}