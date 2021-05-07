package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_proposal extends AppCompatActivity {

    EditText editText_user,editText_order,editText_proposition,editText_cakecost,editText_delivercost,editText_contact;
    Button button_add,button_view;
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
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringUser = editText_user.getText().toString();
                String stringOrder = editText_order.getText().toString();
                String stringProposition = editText_proposition.getText().toString();
                String stringCakecost = editText_cakecost.getText().toString();
                String stringDelivercost = editText_delivercost.getText().toString();
                String stringContacts = editText_cakecost.getText().toString();

                if (stringUser.length() <=0 || stringOrder.length() <=0){
                    Toast.makeText(create_proposal.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelper databaseHelperClass = new DatabaseHelper(create_proposal.this);
                    CakeModel cakeModel = new CakeModel(stringUser,stringOrder,stringProposition,stringCakecost,stringDelivercost,stringContacts);
                    databaseHelperClass.addProposal(cakeModel);
                    Toast.makeText(create_proposal.this, "Add proposal Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(create_proposal.this, ViewCakeActivity.class);
                startActivity(intent);
            }
        });


    }
}
