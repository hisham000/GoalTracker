package com.example.goaltracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddGoalPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner ImpSp;
    EditText GoalNameET;
    EditText DescEt;
    EditText DueDateEt;
    EditText CategEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal_page);
        ImpSp = findViewById(R.id.ImpSp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.imp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ImpSp.setAdapter(adapter);
        ImpSp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}