package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class proposal_modify extends AppCompatActivity {
    DatabaseHelper myDb;
    public Button button;
    EditText edtuser,edtorder,edtproposition,edtcakecost,etddelivercost,edttotalcost,edtcontacts;
    Button update;
    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposal_modify);
        myDb = new DatabaseHelper(this);
        update = (Button) findViewById(R.id.btnUpdate);

        edtuser = (EditText) findViewById(R.id.userid);
        edtorder = (EditText) findViewById(R.id.orderid);
        edtproposition = (EditText) findViewById(R.id.proposition);
        edtcakecost = (EditText) findViewById(R.id.cakecost);
        etddelivercost = (EditText) findViewById(R.id.delivery);
        edttotalcost = (EditText) findViewById(R.id.total);
        edtcontacts = (EditText) findViewById(R.id.contact);
        delete = (Button) findViewById(R.id.btnDelete);
        UpdateData();
        DeleteData();

        button =(Button) findViewById(R.id.cakebtn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(proposal_modify.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void UpdateData(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateData(
                        edtuser.getText().toString(),
                        edtorder.getText().toString(),
                        edtproposition.getText().toString(),
                        edtcakecost.getText().toString(),
                        etddelivercost.getText().toString(),
                        edttotalcost.getText().toString(),
                        edtcontacts.getText().toString());

                if(isUpdate == true)
                    Toast.makeText(proposal_modify.this,"update",Toast.LENGTH_LONG).show();

                    else
                        Toast.makeText(proposal_modify.this,"Proposal Not updated",Toast.LENGTH_LONG).show();

            }

        });
    }


    public void DeleteData(){

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows =myDb.deleteData(edtorder.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(proposal_modify.this,"proposal deleted",Toast.LENGTH_LONG).show();

                else
                    Toast.makeText(proposal_modify.this,"Proposal Not deleted",Toast.LENGTH_LONG).show();

            }
        });
    }
}