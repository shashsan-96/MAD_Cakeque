package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateProfile extends AppCompatActivity {
    DbHandler myDb;
    EditText editFirstName,editLastName,editUserId,editQualifications,editContact,editLocation;

    Button btncreate;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        myDb = new DbHandler(this);

        editFirstName = (EditText) findViewById(R.id.txthint1);
        editLastName = (EditText) findViewById(R.id.txthint2);
        editUserId = (EditText) findViewById(R.id.txthint3);
        editQualifications = (EditText) findViewById(R.id.txthint4);
        editContact = (EditText) findViewById(R.id.txthint5);
        editLocation = (EditText) findViewById(R.id.txthint6);
        btncreate = (Button) findViewById(R.id.btncreate);

        button = (Button) findViewById(R.id.btnCake2);
        AddProfile();
    }

    public void AddProfile () {
        btncreate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editFirstName.getText().toString(),
                                editLastName.getText().toString(),
                                editUserId.getText().toString(),
                                editQualifications.getText().toString(),
                                editContact.getText().toString(),
                                editLocation.getText().toString() );
                        if(isInserted = true)
                            Toast.makeText(CreateProfile.this,"Profile Created",Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(CreateProfile.this,"Profile Not Created",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}