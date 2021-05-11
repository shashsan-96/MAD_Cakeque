package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewAllProfiles extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<ProfileModelClass> profileModelClasses = databaseHelper.getProfileList();

        if (profileModelClasses.size() > 0){
            ProfileAdapterView profileAdapterView = new ProfileAdapterView(profileModelClasses, ViewAllProfiles.this);
            recyclerView.setAdapter(profileAdapterView);
        }else {
            Toast.makeText(this, "There is no profile in the database", Toast.LENGTH_SHORT).show();
        }




    }
}
