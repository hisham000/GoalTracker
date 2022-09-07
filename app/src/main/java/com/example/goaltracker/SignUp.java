package com.example.goaltracker;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText EtFirstName;
    EditText EtLastName;
    EditText ETemail;
    EditText ETpassword;
    EditText ETconfirmPassword;
    Button BtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EtFirstName = findViewById(R.id.EtFirstName);
        EtLastName = findViewById(R.id.EtLastName);
        ETemail = findViewById(R.id.ETemail);
        ETpassword = findViewById(R.id.ETpassword);
        ETconfirmPassword = findViewById(R.id.ETconfirmPassword);
        BtnSignUp = findViewById(R.id.BtnSignUp);

        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(EtFirstName)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(EtLastName)) {
            EtLastName.setError("Last name is required!");
        }

        if (!isEmail(ETemail)) {
            ETemail.setError("Enter valid email!");
        }

    }
}
