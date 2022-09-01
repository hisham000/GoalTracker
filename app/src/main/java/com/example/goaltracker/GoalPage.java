package com.example.goaltracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GoalPage extends AppCompatActivity {
    ArrayList<GoalModel> goalModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_page);
        RecyclerView recyclerView = findViewById(R.id.GoalRV);
        //setUpmethodcall();
        GM_RecyclerViewAdapter adapter = new GM_RecyclerViewAdapter(this,
                goalModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
