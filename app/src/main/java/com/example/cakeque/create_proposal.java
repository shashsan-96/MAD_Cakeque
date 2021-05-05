package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class create_proposal extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText edtuser,edtorder,edtproposition,edtcakecost,etddelivercost,edttotalcost,edtcontacts;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_proposal);
       myDb = new DatabaseHelper(this);
    }
}