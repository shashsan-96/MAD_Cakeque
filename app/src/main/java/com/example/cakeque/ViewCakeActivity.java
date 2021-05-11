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

public class ViewCakeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button10;
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
            Toast.makeText(this, "There is no proposals recently you added", Toast.LENGTH_SHORT).show();
        }

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ViewCakeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
