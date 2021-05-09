package com.example.cakeque;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private EditText emailSignUp , usernameSignUp , passwordSignUp;
    private Button signUpButton;
    private DataHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailSignUp = findViewById(R.id.txt_email);
        usernameSignUp = findViewById(R.id.txtUser);
        passwordSignUp = findViewById(R.id.txtPassword);

        signUpButton = findViewById(R.id.btnSignUp);

        myDB = new DataHelper(this);
        insertUser();
    }

    private void insertUser(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDB.registerUser(usernameSignUp.getText().toString() , emailSignUp.getText().toString() , passwordSignUp.getText().toString());
                if(var){
                    Toast.makeText(SignUp.this, "User Registered Successfully !!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(SignUp.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}