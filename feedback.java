package com.example.cakeque;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class feedback extends AppCompatActivity {

    EditText tvFeedback;
    EditText feedtext;
    RatingBar rbStars;
    Button fsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        feedtext = findViewById(R.id.feedtext);
        tvFeedback = findViewById(R.id.tvFeedback);
        rbStars = findViewById(R.id.rbStars);
        fsubmit = findViewById(R.id.btnSend);



        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating == 0) {
                    tvFeedback.setText("Very Dissatisfied");
                } else if (rating == 1) {
                    tvFeedback.setText("Dissatisfied");
                } else if (rating == 2 || rating == 3) {
                    tvFeedback.setText("OK");
                } else if (rating == 4) {
                    tvFeedback.setText("Satisfied");
                } else if (rating == 5) {
                    tvFeedback.setText("Very Satisfied");
                } else {

                }
            }
        });


        fsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                    String stringRating = tvFeedback.getText().toString();
                    String stringFeedback = feedtext.getText().toString();


                    DatabaseHelper databaseHelperClass = new DatabaseHelper(feedback.this);
                    feedmodel Feedmodel = new feedmodel(stringRating,stringFeedback);
                    databaseHelperClass.insertFeed(Feedmodel);
                    Toast.makeText(feedback.this, "Add feedback successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());





            }
        });



    }


    }







