package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewProfileActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<ProfileModelClass> profileModelClasses = databaseHelperClass.getProfileList();

        if (profileModelClasses.size() > 0){
            ProfileAdapterClass profileadapterclass = new ProfileAdapterClass(profileModelClasses, ViewProfileActivity.this);
            recyclerView.setAdapter(profileadapterclass);
        }else {
            Toast.makeText(this, "There is no profile in the database", Toast.LENGTH_SHORT).show();
        }




    }
}
