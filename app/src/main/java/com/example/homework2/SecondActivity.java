package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView characterImageView;
    TextView longDescription;

    String characterDescription;
    int characterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        characterImageView=findViewById(R.id.characterImage);
        longDescription=findViewById(R.id.descriptionText);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("data3")&& getIntent().hasExtra("characterImage")){

            characterDescription=getIntent().getStringExtra("data3");
            characterImage=getIntent().getIntExtra("characterImage",1);
        }
    }

    private void setData(){
        characterImageView.setImageResource(characterImage);
        longDescription.setText(characterDescription);
    }
}