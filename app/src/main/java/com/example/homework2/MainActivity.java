package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] characters, descriptions,longDescriptions;
    RecyclerView recyclerView;

    int images[]={R.drawable.spongebob,R.drawable.squidward,R.drawable.patrick_star,R.drawable.gary_the_snail,R.drawable.sandy_cheeks};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerView);

        characters=getResources().getStringArray(R.array.characters);
        descriptions=getResources().getStringArray(R.array.descriptions);
        longDescriptions=getResources().getStringArray(R.array.long_descriptions);

        ViewAdapter viewAdapter= new ViewAdapter(this,characters,descriptions,images,longDescriptions);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}