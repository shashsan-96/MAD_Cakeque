package com.example.cakeque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class  LogIn  extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginButton,signup;
    private DatabaseHelper myDb;

    //  //form validation
       AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        loginUsername = findViewById(R.id.loginUser);
        loginPassword = findViewById(R.id.loginpass);
        loginButton = findViewById(R.id.btnLogIn);
        signup = findViewById(R.id.btnSignUp);

        //initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //add validation for user
        awesomeValidation.addValidation(this,R.id.loginUser,
                "[A-Z]{3}[0-9]{2}$",R.string.invalid_user);

        //add validation for passward
        awesomeValidation.addValidation(this,R.id.loginpass,
                RegexTemplate.NOT_EMPTY,R.string.invalid_passward);


        myDb = new DatabaseHelper(this);

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

                //check validation

                if(awesomeValidation.validate()) {




                        boolean var = myDb.checkUser(loginUsername.getText().toString(), loginPassword.getText().toString());
                        if (var) {
                            Toast.makeText(LogIn.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LogIn.this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LogIn.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext()
                                , "validation failed", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }




}