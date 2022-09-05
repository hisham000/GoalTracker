package com.example.goaltracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddGoalPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner ImpSp;
    EditText GoalNameET;
    EditText DescEt;
    EditText DueDateEt;
    EditText CategEt;
    Button AddGoalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal_page);
        ImpSp = findViewById(R.id.ImpSp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.imp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ImpSp.setAdapter(adapter);
        ImpSp.setOnItemSelectedListener(this);
        GoalNameET = findViewById(R.id.GoalNameET);
        DescEt = findViewById(R.id.DescEt);
        DueDateEt = findViewById(R.id.DueDateEt);
        CategEt = findViewById(R.id.CategEt);
        AddGoalBtn = findViewById(R.id.AddGoalBtn);

        AddGoalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String GoalName = GoalNameET.getText().toString().trim();
                String Importance = ImpSp.getSelectedItem().toString();
                String Desc = DescEt.getText().toString();
                String duedate = DueDateEt.getText().toString();
                String Category = CategEt.getText().toString().trim();
                //save to SQLite
                //Somehow get it to appear in recyclerview

            }
        });



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