package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateOrder extends AppCompatActivity {

    //create objects
    public Button cakebtn, btnSubmit;
    public EditText editName, editAddress, editRequirements, editBudget, editDDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        editName = findViewById(R.id.editText_name);
        editAddress = findViewById(R.id.editText_address);
        editRequirements = findViewById(R.id.editText_req);
        editBudget = findViewById(R.id.editTextText_budget);
        editDDate = findViewById(R.id.editText_ddate);

        btnSubmit = findViewById(R.id.cSubmit);
        cakebtn = (Button) findViewById(R.id.button7);

        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String stringName = editName.getText().toString();
                String stringAddress = editAddress.getText().toString();
                String stringRequirements = editRequirements.getText().toString();
                String stringBudget = editBudget.getText().toString();
                String stringDDate = editDDate.getText().toString();

                //check validation if values are empty
                if(stringName.length()<=0 || stringAddress.length()<=0 || stringRequirements.length()<=0 || stringBudget.length()<=0 || stringDDate.length()<=0){
                    Toast.makeText(CreateOrder.this, "Add All Data", Toast.LENGTH_SHORT).show();
                }else{
                    //Create DatabaseHelperClass object and call addOrder method to pass data
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(CreateOrder.this);
                    OrderModelClass orderModelClass = new OrderModelClass(stringName, stringAddress, stringRequirements, stringBudget, stringDDate);
                    databaseHelperClass.addOrder(orderModelClass);
                    Toast.makeText(CreateOrder.this, "Order Added Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        cakebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CreateOrder.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}