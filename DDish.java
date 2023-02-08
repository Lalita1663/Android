package com.example.administrator.ingredion4;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DDish extends AppCompatActivity {

    ArrayList<String > DishList = new ArrayList<String >();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddish);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);

        databaseAccess.open();
        databaseAccess.getDishList(DishList);
        databaseAccess.close();


        ListView listView=(ListView) findViewById(R.id.listviewdish);
        Toast.makeText(getApplicationContext(), ""+DishList+"", Toast.LENGTH_SHORT).show();
        CustomAdapter customAdapter = new CustomAdapter(DishList);
        listView.setAdapter(customAdapter);
    }

    public void StartTrialActivity(View V)
    {
        //Button btn=(Button)findViewById(V.getId());
        TextView value=(TextView) V.findViewById(R.id.textView_dish);
        String s = value.getText().toString();
        //Toast.makeText(getApplicationContext(), ""+s+"", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(DDish.this,display_dish.class);
        intent.putExtra("Name",s);
        startActivity(intent);
    }

    class CustomAdapter extends BaseAdapter {

        ArrayList<String> name;

        public CustomAdapter(ArrayList<String> name) {
            this.name=name;

        }

        @Override
        public int getCount() {
            return name.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.ddish_custom,null);
            TextView ingName = (TextView) view.findViewById(R.id.textView_dish);


            ingName.setText(name.get(i));

            return view;
        }
    }

}
