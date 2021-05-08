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

public class ModifyOrder extends AppCompatActivity {

    public Button cakebtn;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_order);

        recyclerView = findViewById(R.id.recyclerView_Modify);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<OrderModelClass> orderModelClasses = databaseHelperClass.getOrderList();

        if(orderModelClasses.size() > 0){
            OrderModifyAdapterClass orderModifyAdapterClass = new OrderModifyAdapterClass(orderModelClasses, ModifyOrder.this);
            recyclerView.setAdapter(orderModifyAdapterClass);
        }else{
            Toast.makeText(this, "There is no order in the Order List!", Toast.LENGTH_SHORT).show();
        }

        cakebtn = (Button) findViewById(R.id.button4);

        cakebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ModifyOrder.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}