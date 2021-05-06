package com.example.cakeque;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
    Button viewall;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposal_dashboard);
        myDb = new DatabaseHelper(this);
        viewall =(Button) findViewById(R.id.viewprop);
        viewAll();


        button =(Button) findViewById(R.id.button9);






        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(proposal_dashboard.this,create_proposal.class);
                startActivity(intent);




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

public void viewAll(){
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();

                if(res.getCount()== 0){
                    //show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("UserID :"+ res.getString(0)+"\n");
                    buffer.append("OrderID :"+ res.getString(1)+"\n");
                    buffer.append("proposition :"+ res.getString(2)+"\n");
                    buffer.append("cakecost :"+ res.getString(3)+"\n");
                    buffer.append("Delivercost :"+ res.getString(4)+"\n");
                    buffer.append("Totalcost :"+ res.getString(5)+"\n");
                    buffer.append("Contacts :"+ res.getString(6)+"\n\n");

                }

                //show all data
                showMessage("Data",buffer.toString());


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