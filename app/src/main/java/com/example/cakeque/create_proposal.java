package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class create_proposal extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText edtuser,edtorder,edtproposition,edtcakecost,etddelivercost,edttotalcost,edtcontacts;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_proposal);
       myDb = new DatabaseHelper(this);

        edtuser = (EditText) findViewById(R.id.userid);
        edtorder = (EditText) findViewById(R.id.orderid);
        edtproposition = (EditText) findViewById(R.id.proposition);
        edtcakecost = (EditText) findViewById(R.id.cakecost);
        etddelivercost = (EditText) findViewById(R.id.delivery);
        edttotalcost = (EditText) findViewById(R.id.total);
        edtcontacts = (EditText) findViewById(R.id.contact);
        submit = (Button) findViewById(R.id.submit);
        AddProposal();
    }

    public void AddProposal(){
        submit.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               boolean isInserted = myDb.insertData(edtuser.getText().toString() ,
                        edtorder.getText().toString(),
                        edtproposition.getText().toString(),
                        edtcakecost.getText().toString(),
                        etddelivercost.getText().toString(),
                        edttotalcost.getText().toString(),
                        edtcontacts.getText().toString()  );

                if(isInserted == true)
                    Toast.makeText(create_proposal.this,"Proposal Created",Toast.LENGTH_LONG).show();

                else
                    Toast.makeText(create_proposal.this,"Proposal Not Created",Toast.LENGTH_LONG).show();



            }
        });
    }
}