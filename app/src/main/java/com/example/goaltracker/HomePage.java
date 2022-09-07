package com.example.goaltracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {
    ImageView IVGoalPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        IVGoalPage = findViewById(R.id.IVGoalPage);
    }

    public void IVGoalPage(View v)
    {
        startActivity(new Intent(HomePage.this,GoalPage.class));
    }


} //