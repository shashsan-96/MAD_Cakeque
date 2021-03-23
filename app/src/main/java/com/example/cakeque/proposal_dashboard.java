package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class proposal_dashboard extends AppCompatActivity {
    public Button button;
    public Button button1;
    public Button button3;
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

        button1 =(Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent1= new Intent(proposal_dashboard.this,view_profile.class);
                startActivity(intent1);


            }
        });

        button3 =(Button) findViewById(R.id.button11);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent3= new Intent(proposal_dashboard.this,proposal_modify.class);
                startActivity(intent3);


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