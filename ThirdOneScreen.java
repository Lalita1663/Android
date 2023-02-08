package com.example.administrator.ingredion4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdOneScreen extends AppCompatActivity {

    public Button view, but31;

    public  void init1(){
        view= (Button) findViewById(R.id.view);
        but31= (Button) findViewById(R.id.but31);


        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent toy1  = new Intent(ThirdOneScreen.this,AddIngred.class);
                startActivity(toy1);
            }
        });

        but31.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent toy1  = new Intent(ThirdOneScreen.this,ViewIngred.class);
                startActivity(toy1);
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_one_screen);
        init1();
    }
}
