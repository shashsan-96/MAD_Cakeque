package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateOrder extends AppCompatActivity {

    public Button cakebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        cakebtn = (Button) findViewById(R.id.button7);

        cakebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CreateOrder.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}