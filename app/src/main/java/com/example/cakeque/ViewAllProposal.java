
package com.example.cakeque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAllProposal extends AppCompatActivity {


    RecyclerView recyclerView;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_proposal);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        DatabaseHelper databaseHelperClass = new DatabaseHelper(this);
        List<CakeModel> cakeModels = databaseHelperClass.getProposalList();

        if (cakeModels.size() > 0) {
            proAdapterView proposalAdapterClass = new proAdapterView(cakeModels, ViewAllProposal.this);
            recyclerView.setAdapter(proposalAdapterClass);
        } else {
            Toast.makeText(this, "There is no proposal you recently added", Toast.LENGTH_SHORT).show();
        }

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ViewAllProposal.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}

package com.example.cakeque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAllProposal extends AppCompatActivity {


    RecyclerView recyclerView;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_proposal);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        DatabaseHelper databaseHelperClass = new DatabaseHelper(this);
        List<CakeModel> cakeModels = databaseHelperClass.getProposalList();

        if (cakeModels.size() > 0) {
            proAdapterView proposalAdapterClass = new proAdapterView(cakeModels, ViewAllProposal.this);
            recyclerView.setAdapter(proposalAdapterClass);
        } else {
            Toast.makeText(this, "There is no proposal you recently added", Toast.LENGTH_SHORT).show();
        }

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ViewAllProposal.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}

