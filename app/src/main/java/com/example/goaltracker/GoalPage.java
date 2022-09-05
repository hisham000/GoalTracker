package com.example.goaltracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class GoalPage extends AppCompatActivity {
    ArrayList<GoalModel> goalModels = new ArrayList<>();
    TextView Num_of_coins;
    FloatingActionButton Add_Goal_Button;

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
        Add_Goal_Button = findViewById(R.id.Add_Goal_Button);
        Num_of_coins = findViewById(R.id.Num_of_coins);


        Add_Goal_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoalPage.this,AddGoalPage.class));
            }
        });


    }



}
