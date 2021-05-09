package com.example.cakeque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class  LogIn  extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginButton,signup;
    private DataHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        loginUsername = findViewById(R.id.loginUser);
        loginPassword = findViewById(R.id.loginpass);
        loginButton = findViewById(R.id.btnLogIn);
        signup = findViewById(R.id.btnSignUp);


        myDb = new DataHelper(this);

        loginUser();


        signup = (Button) findViewById(R.id.btnSignUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });

    }
    private void loginUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.checkUser(loginUsername.getText().toString() , loginPassword.getText().toString());
                if (var){
                    Toast.makeText( LogIn .this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent( LogIn .this , MainActivity.class));
                    finish();
                }else{
                    Toast.makeText( LogIn .this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}