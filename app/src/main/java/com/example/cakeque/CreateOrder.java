package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class CreateOrder extends AppCompatActivity{

    //create objects
    public Button cakebtn, btnSubmit;
    public EditText editName, editAddress, editRequirements, editBudget, editDDate;

    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;

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

        //initializing awesomevalidation object
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.editText_name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        /*awesomeValidation.addValidation(this,R.id.editText_address, RegexTemplate.NOT_EMPTY,R.string.addresserror);
        awesomeValidation.addValidation(this,R.id.editText_req, RegexTemplate.NOT_EMPTY,R.string.reqerror);
        awesomeValidation.addValidation(this,R.id.editText_budget, RegexTemplate.NOT_EMPTY,R.string.budgeterror);*/
        awesomeValidation.addValidation(this, R.id.editText_ddate, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);


        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                if(awesomeValidation.validate()){
                   //on success
                    Toast.makeText(getApplicationContext()
                            ," validation successful...",Toast.LENGTH_SHORT).show();

                    String stringName = editName.getText().toString();
                    String stringAddress = editAddress.getText().toString();
                    String stringRequirements = editRequirements.getText().toString();
                    String stringBudget = editBudget.getText().toString();
                    String stringDDate = editDDate.getText().toString();

                    //check validation if values are empty
                /*if(stringName.length()<=0 || stringAddress.length()<=0 || stringRequirements.length()<=0 || stringBudget.length()<=0 || stringDDate.length()<=0){
                    Toast.makeText(CreateOrder.this, "Add All Data", Toast.LENGTH_SHORT).show();*/
                    /*    }else{*/

                    //Create DatabaseHelperClass object and call addOrder method to pass data
                    DatabaseHelper databaseHelper = new DatabaseHelper(CreateOrder.this);
                    int orderid = databaseHelper.getAutoIncrementID();
                    OrderModelClass orderModelClass = new OrderModelClass(orderid, stringName, stringAddress, stringRequirements, stringBudget, stringDDate);
                    databaseHelper.addOrder(orderModelClass);
                    Toast.makeText(CreateOrder.this, "Order Added Successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }else{
                    Toast.makeText(CreateOrder.this, "Validation Failed!", Toast.LENGTH_SHORT).show();
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
