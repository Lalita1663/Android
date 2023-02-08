package com.example.administrator.ingredion4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondScreen extends AppCompatActivity {

    public Button ing,dish,list;
    public  void init1(){
        ing= (Button) findViewById(R.id.ing);
        dish= (Button) findViewById(R.id.dish);
        list= (Button) findViewById(R.id.list);


        ing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent toy1  = new Intent(SecondScreen.this,ViewIngred.class);

                startActivity(toy1);
            }
        });

        dish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent toy1  = new Intent(SecondScreen.this,DDish.class);
                startActivity(toy1);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent toy1  = new Intent(SecondScreen.this,ListOpening.class);
                startActivity(toy1);
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        init1();
    }
}
