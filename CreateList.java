package com.example.administrator.ingredion4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateList extends AppCompatActivity {


    String[]  Names = {"n1","n2","n3"};
    String [] Qtyy = {"1","2","3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<String> name = getIntent().getStringArrayListExtra("Name");
        ListView listView=(ListView) findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Names.length;
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
            view = getLayoutInflater().inflate(R.layout.custom_layout,null);
           // TextView ingName = (TextView) view.findViewById(R.id.textView3_ingName);
           // EditText ingQty = (EditText) view.findViewById(R.id.editText_ingQty);

            //ingName.setText(Names[i]);
            //ingQty.setText(Qtyy[i]);

            return view;
        }
    }
}
