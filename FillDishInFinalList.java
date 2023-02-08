package com.example.administrator.ingredion4;

import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FillDishInFinalList extends AppCompatActivity {


    //DisplayList

    public TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_dish_in_final_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tv1=(TextView)findViewById(R.id.name2);
        tv2=(TextView)findViewById(R.id.mobile);
        tv3=(TextView)findViewById(R.id.office);
        tv4=(TextView)findViewById(R.id.email);
        tv5=(TextView)findViewById(R.id.designation);
        tv6=(TextView)findViewById(R.id.department);
        tv7=(TextView)findViewById(R.id.Residence);
        StringBuilder v1=new StringBuilder();
        StringBuilder v2=new StringBuilder();
        StringBuilder v3=new StringBuilder();
        StringBuilder v4=new StringBuilder();
        StringBuilder v5=new StringBuilder();
        StringBuilder v6=new StringBuilder();
        StringBuilder v7=new StringBuilder();
        v1.setLength(0);
        v2.setLength(0);
        v3.setLength(0);
        v4.setLength(0);
        v5.setLength(0);
        v6.setLength(0);
        v7.setLength(0);

        ArrayList<String> name = getIntent().getStringArrayListExtra("Name");
        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);
        try {
            databaseAccess.open();


            // Toast.makeText(getApplicationContext(), "This is working!", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){
            // Toast.makeText(getApplicationContext(), "crap!", Toast.LENGTH_SHORT).show();
        }

        try {
            databaseAccess.getList(name,v1,v2,v3,v4,v5,v6,v7);


            //Toast.makeText(getApplicationContext(), "This is working!", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){
            //Toast.makeText(getApplicationContext(), "crap!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(), ""+name+"", Toast.LENGTH_SHORT).show();


        databaseAccess.close();
        tv1.setText("  "+v1);
        tv2.setText("  "+v2);
        tv3.setText("  "+v3);
        tv4.setText("  "+v4);
        tv5.setText("  "+v5);
        tv6.setText("  "+v6);
         tv7.setText("  "+v7);

    }
}
