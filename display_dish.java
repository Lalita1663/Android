package com.example.administrator.ingredion4;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class display_dish extends AppCompatActivity {

    ArrayList<String > DishList = new ArrayList<String >();
    ArrayList<Integer> DishListQ = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dish);





        String name = getIntent().getStringExtra("Name");
        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);

        databaseAccess.open();
        databaseAccess.getDish2(name,DishList);
        databaseAccess.close();

        ListView listView=(ListView) findViewById(R.id.listviewdish2);
       // Toast.makeText(getApplicationContext(), ""+DishList+"", Toast.LENGTH_SHORT).show();
        CustomAdapter customAdapter = new CustomAdapter(DishList);
        listView.setAdapter(customAdapter);




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
            view = getLayoutInflater().inflate(R.layout.custom_display_dish,null);
            TextView ingName = (TextView) view.findViewById(R.id.textView_dish2);


            ingName.setText(name.get(i));

            return view;
        }
    }

}
