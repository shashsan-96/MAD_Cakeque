package com.example.cakeque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class ProfileDashboard extends AppCompatActivity {
    DbHandler myDb;
    public Button button;
    public Button button1;
    public Button btnview;
    public Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dashboard);
        myDb = new DbHandler(this);
        btnview =(Button) findViewById(R.id.btnpro);
        viewAll();

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

        button3 = (Button) findViewById(R.id.btnup);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(ProfileDashboard.this,ModifyPage.class);
                startActivity(intent3);
            }
        });

    }

    public void viewAll(){
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();

                if(res.getCount()== 0){
                    //show message
                    showMessage("Error","No Data found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("First Name :"+ res.getString(0)+"\n");
                    buffer.append("Last Name :"+ res.getString(1)+"\n");
                    buffer.append("User ID :"+ res.getString(2)+"\n");
                    buffer.append("Qualifications :"+ res.getString(3)+"\n");
                    buffer.append("Contact :"+ res.getString(4)+"\n");
                    buffer.append("Location :"+ res.getString(5)+"\n\n");


                }

                //show all data
                showMessage("Profiles",buffer.toString());


            }
        });

    }

    public  void showMessage(String title,String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}