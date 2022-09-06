package com.example.goaltracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        setUpGoalModels();

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
    private void setUpGoalModels(){


        try{
            GoalsDB db = new GoalsDB(this);
            db.open();
            ArrayList<String> goalnames = db.getNameList();
            ArrayList<String> desc = db.getDiscList();
            ArrayList<String> category = db.getCategoryList();
            ArrayList<String> duedate=  db.getDueDateList();
            ArrayList<String> importance = db.getImportanceList();
            ArrayList<String> pp = db.getPpList();
            db.close();
            for (int i = 0; i < goalnames.size();i++){
                goalModels.add(new GoalModel(goalnames.get(i), pp.get(i),importance.get(i),duedate.get(i),category.get(i),desc.get(i)));
            }
        }
        catch (SQLException e){
            Toast.makeText(GoalPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }



}
