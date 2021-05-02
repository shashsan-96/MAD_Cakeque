package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {
    public Button button;
    public Button button1;
    public Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);



        button = (Button) findViewById(R.id.btnReset1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this,Reset.class);
                startActivity(intent);
            }
        });

        button1 = (Button) findViewById(R.id.btnSignUp1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LogIn.this,SignUp.class);
                startActivity(intent1);
            }
        });

        button2 = (Button) findViewById(R.id.btnLogIn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LogIn.this,userPage.class);
                startActivity(intent2);
            }
        });
    }
}