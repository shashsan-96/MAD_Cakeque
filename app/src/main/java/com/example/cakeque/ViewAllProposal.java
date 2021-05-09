package com.example.cakeque;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAllProposal extends AppCompatActivity {


    RecyclerView recyclerView;

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
    }
}
