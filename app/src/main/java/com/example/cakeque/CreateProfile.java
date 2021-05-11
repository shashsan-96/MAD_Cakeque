package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class CreateProfile extends AppCompatActivity {

    EditText editText_fname,editText_lname,editText_userid,editText_qualifications,editText_contact,editText_location;
    Button button_add,button_cake;

    AwesomeValidation awesomeValidation;
    Animation scaleUp,scaleDown;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        //Assign Variable
        editText_fname = findViewById(R.id.edittext_fname);
        editText_lname = findViewById(R.id.edittext_lname);
        editText_userid = findViewById(R.id.edittext_userid);
        editText_qualifications = findViewById(R.id.edittext_qualification);
        editText_contact = findViewById(R.id.edittext_contact);
        editText_location = findViewById(R.id.edittext_location);
        button_add = findViewById(R.id.button_add);
        button_cake = findViewById(R.id.button7);

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);



        //Add validations
        awesomeValidation.addValidation(this,R.id.edittext_fname,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.invalidFname);

        awesomeValidation.addValidation(this,R.id.edittext_lname,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ,R.string.invalidLastname);

        awesomeValidation.addValidation(this,R.id.edittext_userid,
                RegexTemplate.NOT_EMPTY,R.string.invalid_userid);

        awesomeValidation.addValidation(this,R.id.edittext_qualification,
                RegexTemplate.NOT_EMPTY,R.string.invalid_qualification);

        awesomeValidation.addValidation(this,R.id.edittext_contact,
                "[0-9]{10}$",R.string.invalidContact);


        awesomeValidation.addValidation(this,R.id.edittext_location,
                RegexTemplate.NOT_EMPTY,R.string.invalid_location);



        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //for validation checking

                if (awesomeValidation.validate()) {
                    //success message
                    Toast.makeText(getApplicationContext()
                            , "Form Validate Successful", Toast.LENGTH_SHORT).show();

                    String stringFirstName = editText_fname.getText().toString();
                    String stringLastName = editText_lname.getText().toString();
                    String stringUserId = editText_userid.getText().toString();
                    String stringQualification = editText_qualifications.getText().toString();
                    String stringContact = editText_contact.getText().toString();
                    String stringLocation = editText_location.getText().toString();


                    if (stringFirstName.length() <= 0 || stringLastName.length() <= 0) {
                        Toast.makeText(CreateProfile.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                    } else {
                        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(CreateProfile.this);
                        ProfileModelClass profileModelClass = new ProfileModelClass(stringFirstName, stringLastName, stringUserId, stringQualification, stringContact, stringLocation);
                        databaseHelperClass.addProfile(profileModelClass);
                        Toast.makeText(CreateProfile.this, "Create Profile Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(getIntent());
                    }
                } else {
                    Toast.makeText(getApplicationContext()
                            , "Validation Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button_cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CreateProfile.this,MainActivity.class);
                startActivity(intent);
            }
        });


        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        button_add.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    button_add.startAnimation(scaleUp);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {

                    button_add.startAnimation(scaleDown);
                }

                return false;
            }
        });

    }
}
