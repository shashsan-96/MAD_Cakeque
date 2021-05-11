
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

public class create_proposal extends AppCompatActivity {

    //initialize variable
    EditText editText_user,editText_order,editText_proposition,editText_cakecost,editText_delivercost,editText_contact;
    Button button_add,button7;

    //form validation
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_proposal);

        editText_user = findViewById(R.id.edittext_user);
        editText_order = findViewById(R.id.edittext_order);
        editText_proposition = findViewById(R.id.edittext_proposition);
        editText_cakecost = findViewById(R.id.edittext_cakecost);
        editText_delivercost = findViewById(R.id.edittext_delivercost);
        editText_contact = findViewById(R.id.edittext_contacts);
        button_add = findViewById(R.id.button_add);
        button7 = findViewById(R.id.button7);

        //initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //add validation for user
        awesomeValidation.addValidation(this,R.id.edittext_user,
                "[A-Z]{3}[0-9]{2}$",R.string.invalid_user);

        //add validation for order
        awesomeValidation.addValidation(this,R.id.edittext_order,
                RegexTemplate.NOT_EMPTY,R.string.invalid_order);

        //add validation for proposition
        awesomeValidation.addValidation(this,R.id.edittext_proposition,
                RegexTemplate.NOT_EMPTY,R.string.invalid_proposition);

        //add validation for cake cost
        awesomeValidation.addValidation(this,R.id.edittext_cakecost,
                RegexTemplate.NOT_EMPTY,R.string.invalid_cakecost);

        //add validation for deliver cost
        awesomeValidation.addValidation(this,R.id.edittext_delivercost,
                RegexTemplate.NOT_EMPTY,R.string.invalid_delivercost);

        //For contacts
        awesomeValidation.addValidation(this,R.id.edittext_contacts,
                "[0-9]{10}$",R.string.invalid_contacts);


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(create_proposal.this,MainActivity.class);
                startActivity(intent);
            }
        });


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check validation

                if(awesomeValidation.validate()){
                    //on success
                    Toast.makeText(getApplicationContext()
                    ," validation successful...",Toast.LENGTH_SHORT).show();


//ADD PROPOSAL
                String stringUser = editText_user.getText().toString();
                String stringOrder = editText_order.getText().toString();
                String stringProposition = editText_proposition.getText().toString();
                String stringCakecost = editText_cakecost.getText().toString();
                String stringDelivercost = editText_delivercost.getText().toString();
                String stringContacts = editText_contact.getText().toString();


                    DatabaseHelper databaseHelperClass = new DatabaseHelper(create_proposal.this);
                    CakeModel cakeModel = new CakeModel(stringUser,stringOrder,stringProposition,stringCakecost,stringDelivercost,stringContacts);
                    databaseHelperClass.addProposal(cakeModel);
                    Toast.makeText(create_proposal.this, "Add proposal Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());

                }else{
                    Toast.makeText(getApplicationContext()
                            ,"validation failed",Toast.LENGTH_SHORT).show();
                }



            }
        });



    }
}

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

public class create_proposal extends AppCompatActivity {

    //initialize variable
    EditText editText_user,editText_order,editText_proposition,editText_cakecost,editText_delivercost,editText_contact;
    Button button_add,button7;

    //form validation
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_proposal);

        editText_user = findViewById(R.id.edittext_user);
        editText_order = findViewById(R.id.edittext_order);
        editText_proposition = findViewById(R.id.edittext_proposition);
        editText_cakecost = findViewById(R.id.edittext_cakecost);
        editText_delivercost = findViewById(R.id.edittext_delivercost);
        editText_contact = findViewById(R.id.edittext_contacts);
        button_add = findViewById(R.id.button_add);
        button7 = findViewById(R.id.button7);

        //initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //add validation for user
        awesomeValidation.addValidation(this,R.id.edittext_user,
                "[A-Z]{3}[0-9]{2}$",R.string.invalid_user);

        //add validation for order
        awesomeValidation.addValidation(this,R.id.edittext_order,
                RegexTemplate.NOT_EMPTY,R.string.invalid_order);

        //add validation for proposition
        awesomeValidation.addValidation(this,R.id.edittext_proposition,
                RegexTemplate.NOT_EMPTY,R.string.invalid_proposition);

        //add validation for cake cost
        awesomeValidation.addValidation(this,R.id.edittext_cakecost,
                RegexTemplate.NOT_EMPTY,R.string.invalid_cakecost);

        //add validation for deliver cost
        awesomeValidation.addValidation(this,R.id.edittext_delivercost,
                RegexTemplate.NOT_EMPTY,R.string.invalid_delivercost);

        //For contacts
        awesomeValidation.addValidation(this,R.id.edittext_contacts,
                "[0-9]{10}$",R.string.invalid_contacts);


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(create_proposal.this,MainActivity.class);
                startActivity(intent);
            }
        });


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check validation

                if(awesomeValidation.validate()){
                    //on success
                    Toast.makeText(getApplicationContext()
                    ," validation successful...",Toast.LENGTH_SHORT).show();


//ADD PROPOSAL
                String stringUser = editText_user.getText().toString();
                String stringOrder = editText_order.getText().toString();
                String stringProposition = editText_proposition.getText().toString();
                String stringCakecost = editText_cakecost.getText().toString();
                String stringDelivercost = editText_delivercost.getText().toString();
                String stringContacts = editText_contact.getText().toString();


                    DatabaseHelper databaseHelperClass = new DatabaseHelper(create_proposal.this);
                    CakeModel cakeModel = new CakeModel(stringUser,stringOrder,stringProposition,stringCakecost,stringDelivercost,stringContacts);
                    databaseHelperClass.addProposal(cakeModel);
                    Toast.makeText(create_proposal.this, "Add proposal Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());

                }else{
                    Toast.makeText(getApplicationContext()
                            ,"validation failed",Toast.LENGTH_SHORT).show();
                }



            }
        });



    }
}

