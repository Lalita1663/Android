package com.example.administrator.ingredion4;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class ViewIngred extends AppCompatActivity {


    ArrayList<String > IngoList = new ArrayList<String >();
    ArrayList<String > IngoListid = new ArrayList<String >();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ingred);


        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);

        databaseAccess.open();



        databaseAccess.getIngredientList(IngoList,IngoListid);
        databaseAccess.close();


        //Toast.makeText(getApplicationContext(), ""+IngoList+"", Toast.LENGTH_SHORT).show();
        ListView listView=(ListView) findViewById(R.id.listviewIngred);
       CustomAdapter customAdapter = new CustomAdapter(IngoList,IngoListid);
        listView.setAdapter(customAdapter);


    }



        class CustomAdapter extends BaseAdapter {

            ArrayList<String> name;
            ArrayList<String> id;
            public CustomAdapter(ArrayList<String> name,ArrayList<String > id) {
                this.name=name;
                this.id=id;
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
                view = getLayoutInflater().inflate(R.layout.custom_list_item,null);
                TextView ingName = (TextView) view.findViewById(R.id.tv_ing_name);
                TextView ing_id = (TextView) view.findViewById(R.id.tv_ing_id);

                ingName.setText(name.get(i));
                ing_id.setText(id.get(i));

                return view;
            }
        }







}
