package com.example.cakeque;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class SignUp extends AppCompatActivity {
    private EditText emailSignUp , usernameSignUp , passwordSignUp;
    private Button signUpButton;
    private DatabaseHelper myDB;

      //form validation
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailSignUp = findViewById(R.id.txt_email);
        usernameSignUp = findViewById(R.id.txtUser);
        passwordSignUp = findViewById(R.id.txtPassword);
        signUpButton = findViewById(R.id.btnSignUp);

        //initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //add validation for Email
        awesomeValidation.addValidation(this,R.id.txt_email
                , Patterns.EMAIL_ADDRESS,R.string.invalid_emil);


        //add validation for username
        awesomeValidation.addValidation(this,R.id.txtUser,
                "[A-Z]{3}[0-9]{2}$",R.string.invalid_user);

        //add validation for passward
        awesomeValidation.addValidation(this,R.id.txtPassword,
                RegexTemplate.NOT_EMPTY,R.string.invalid_passward);


        myDB = new DatabaseHelper(this);
        insertUser();
    }


    private void insertUser(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check validation

                if (awesomeValidation.validate()) {
                    //on success
                    Toast.makeText(getApplicationContext()
                            , "Form validation successfully...", Toast.LENGTH_SHORT).show();
                    Boolean usernamecheck = myDB.checkusername(usernameSignUp.getText().toString());
                    if (usernamecheck == false) {


                        boolean var = myDB.registerUser(usernameSignUp.getText().toString(), emailSignUp.getText().toString(), passwordSignUp.getText().toString());
                        if (var) {
                            Toast.makeText(SignUp.this, "You Registered to cakeque Successfully !!", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(SignUp.this, "Registration Error Please enter valid details !!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUp.this, "oops username exist try another", Toast.LENGTH_SHORT).show();
                    }
                }else{
                Toast.makeText(getApplicationContext()
                        ,"validation failed",Toast.LENGTH_SHORT).show();
            }


            }


        });
    }
}