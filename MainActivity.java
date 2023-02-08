package com.example.administrator.ingredion4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*
    public Button but1;
    public  void init(){
        but1 = (Button) findViewById(R.id.but1);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy  = new Intent(MainActivity.this,SecondScreen.class);
                startActivity(toy);
            }
        });


    }
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // init();
        Thread myThread=new Thread(){
            @Override
            public  void run(){
                try{
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),SecondScreen.class);
                    startActivity(intent);
                    finish();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();




    }
}
