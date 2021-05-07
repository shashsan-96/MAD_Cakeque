package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewCakeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_proposal);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelper databaseHelperClass = new DatabaseHelper(this);
        List<CakeModel> cakeModels = databaseHelperClass.getProposalList();

        if (cakeModels.size() > 0){
            ProposalAdapterClass proposalAdapterClass = new ProposalAdapterClass(cakeModels, ViewCakeActivity.this);
            recyclerView.setAdapter(proposalAdapterClass);
        }else {
            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
        }




    }
}
