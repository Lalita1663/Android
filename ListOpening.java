package com.example.administrator.ingredion4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListOpening extends AppCompatActivity {

    Button btn;
    EditText name1,nop,date;
    ArrayList<String > record = new ArrayList<String >();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_opening);
        btn=(Button)findViewById(R.id.menu);
        name1 = (EditText) findViewById(R.id.namelist);
        nop=(EditText) findViewById(R.id.nop);
        date = (EditText) findViewById(R.id.date);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    record.add(name1.getText().toString());
                    record.add(nop.getText().toString());
                    record.add(date.getText().toString());
               // Toast.makeText(getApplicationContext(), ""+record+"", Toast.LENGTH_SHORT).show();


                Intent intent=new Intent(ListOpening.this,SelectDish.class);
              intent.putExtra("Name",record);
                startActivity(intent);
            }
        });
    }


}

