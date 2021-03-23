package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class ViewPage extends AppCompatActivity {
    public Button button;
    public Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        button = (Button) findViewById(R.id.btnCake3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPage.this,MainActivity.class);
                startActivity(intent);
            }
        });

        button1 = (Button) findViewById(R.id.btnSearch);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ViewPage.this,OneProfile.class);
                startActivity(intent1);
            }
        });
    }
}