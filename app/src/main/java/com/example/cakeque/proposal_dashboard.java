package com.example.cakeque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class proposal_dashboard extends AppCompatActivity {
    public Button button;
    public Button button_profit;
    public Button viewproposal;
    public Button button4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposal_dashboard);
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


        button4 =(Button) findViewById(R.id.modify_btn);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent4= new Intent(proposal_dashboard.this,ViewCakeActivity.class);
                startActivity(intent4);


            }

        });


        button_profit =(Button) findViewById(R.id.button_profit);
        button_profit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent5= new Intent(proposal_dashboard.this,profitcalculator.class);
                startActivity(intent5);


            }

        });


        viewproposal =(Button) findViewById(R.id.viewproposal);
        viewproposal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent6= new Intent(proposal_dashboard.this,ViewAllProposal.class);
                startActivity(intent6);


            }

        });




    }
}