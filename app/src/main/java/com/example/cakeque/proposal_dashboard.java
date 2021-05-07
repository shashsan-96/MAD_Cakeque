package com.example.cakeque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class proposal_dashboard extends AppCompatActivity {

    DatabaseHelper myDb;
    public Button button;
    public Button button1;
    public Button button3;
    public Button button4;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposal_dashboard);
        myDb = new DatabaseHelper(this);



        button =(Button) findViewById(R.id.button9);






        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(proposal_dashboard.this,create_proposal.class);
                startActivity(intent);




        }
    });






        button4 =(Button) findViewById(R.id.cakebtn);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent4= new Intent(proposal_dashboard.this,MainActivity.class);
                startActivity(intent4);


            }

        });






}


}