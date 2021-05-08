package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateProfile extends AppCompatActivity {

    EditText editText_fname,editText_lname,editText_userid,editText_qualifications,editText_contact,editText_location;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        editText_fname = findViewById(R.id.edittext_fname);
        editText_lname = findViewById(R.id.edittext_lname);
        editText_userid = findViewById(R.id.edittext_userid);
        editText_qualifications = findViewById(R.id.edittext_qualification);
        editText_contact = findViewById(R.id.edittext_contact);
        editText_location = findViewById(R.id.edittext_location);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringFirstName = editText_fname.getText().toString();
                String stringLastName=editText_lname.getText().toString();
                String stringUserId=editText_userid.getText().toString();
                String stringQualification=editText_qualifications.getText().toString();
                String stringContact=editText_contact.getText().toString();
                String stringLocation=editText_location.getText().toString();


                if (stringFirstName.length() <=0 || stringLastName.length() <=0){
                    Toast.makeText(CreateProfile.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(CreateProfile.this);
                    ProfileModelClass profileModelClass = new ProfileModelClass(stringFirstName,stringLastName,stringUserId,stringQualification,stringContact,stringLocation);
                    databaseHelperClass.addProfile(profileModelClass);
                    Toast.makeText(CreateProfile.this, "Create Profile Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateProfile.this, ViewProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}
