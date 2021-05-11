package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class OrderList extends AppCompatActivity {

    public Button cakebtn;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //Create DatabaseHelperClass object and call gerOrder method and set on RecyclerViewAdapter class
        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<OrderModelClass> orderModelClasses = databaseHelperClass.getOrderList();

        if(orderModelClasses.size() > 0){
            OrderAdapterClass orderAdapterClass = new OrderAdapterClass(orderModelClasses, OrderList.this);
            recyclerView.setAdapter(orderAdapterClass);

        }else{
            Toast.makeText(this, "There is no order in Order List!", Toast.LENGTH_SHORT).show();
        }

        cakebtn = (Button) findViewById(R.id.button10);

        cakebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(OrderList.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}