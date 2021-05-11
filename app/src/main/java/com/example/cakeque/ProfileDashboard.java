package com.example.cakeque;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ProfileDashboard extends AppCompatActivity {

    public Button button;
    public Button button1;
    public Button btnview;
    public Button modify;
    Animation scaleUp,scaleDown;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dashboard);


        button = (Button) findViewById(R.id.btnCake);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileDashboard.this,MainActivity.class);
                startActivity(intent);
            }

        });
        button1 = (Button) findViewById(R.id.btncen);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ProfileDashboard.this,CreateProfile.class);
                startActivity(intent1);
            }
        });

        modify=(Button) findViewById(R.id.btnup);
        modify.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent2= new Intent(ProfileDashboard.this,ViewProfileActivity.class);
                startActivity(intent2);

            }
        });

        btnview =(Button) findViewById(R.id.btnpro);
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(ProfileDashboard.this,ViewAllProfiles.class);
                startActivity(intent3);
            }
        });

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    button1.startAnimation(scaleUp);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {

                    button1.startAnimation(scaleDown);
                }

                return false;
            }
        });

        btnview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    btnview.startAnimation(scaleUp);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {

                    btnview.startAnimation(scaleDown);
                }

                return false;
            }
        });

        modify.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    modify.startAnimation(scaleUp);
                }else if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {

                    modify.startAnimation(scaleDown);
                }

                return false;
            }
        });

    }



}