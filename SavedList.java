package com.example.administrator.ingredion4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SavedList extends AppCompatActivity {
    ArrayList<String> event;
    ArrayList<String> dishname;
    ArrayList<String > IngName;
    ArrayList<String > IngQty;
    TextView t1,t2,t3;
    String listID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listID = String.valueOf(getIntent().getStringArrayListExtra("ListID"));
        Toast.makeText(getApplicationContext(), ""+listID+"", Toast.LENGTH_SHORT).show();

        dishname = getIntent().getStringArrayListExtra("Name");  //dhish names
        event = getIntent().getStringArrayListExtra("EventDetail");
        IngName = getIntent().getStringArrayListExtra("ingNames");
        IngQty = getIntent().getStringArrayListExtra("Qty");


        //Toast.makeText(getApplicationContext(), ""+event+"", Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), ""+dishname+"", Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), ""+IngName+"", Toast.LENGTH_SHORT).show();
       // Toast.makeText(getApplicationContext(), ""+IngQty+"", Toast.LENGTH_SHORT).show();

        ListView listView=(ListView) findViewById(R.id.showalling);
        CustomAdapter1 customAdapter = new CustomAdapter1(IngName,IngQty);
        listView.setAdapter(customAdapter);

        ListView listView2=(ListView) findViewById(R.id.showalldishes);
        CustomAdapter2 customAdapter2 = new CustomAdapter2(dishname);
        listView2.setAdapter(customAdapter2);

        t1 = (TextView) findViewById(R.id.ename);
        t2 = (TextView) findViewById(R.id.nop2);
        t3 = (TextView) findViewById(R.id.date2);

        t1.setText("Event Name :: "+event.get(0));
        t2.setText("Number of People :: "+event.get(1));
        t3.setText("Date :: "+event.get(2));





    }

    class CustomAdapter1 extends BaseAdapter{

        ArrayList<String> name;
        ArrayList<String > qty;

        public CustomAdapter1(ArrayList<String> name, ArrayList<String > ingQty) {
            this.name=name;
            this.qty = ingQty;

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
            view = getLayoutInflater().inflate(R.layout.customdish_item,null);
            TextView ingName = (TextView) view.findViewById(R.id.tv_ing_name33);
            TextView ing_id = (TextView) view.findViewById(R.id.tv_ing_id33);

            ingName.setText(name.get(i));
            ing_id.setText(qty.get(i));

            return view;
        }
    }

    class CustomAdapter2 extends BaseAdapter {

        ArrayList<String> name;

        public CustomAdapter2(ArrayList<String> name) {
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
            view = getLayoutInflater().inflate(R.layout.custom_list_item,null);
            TextView ingName = (TextView) view.findViewById(R.id.tv_ing_name);
            TextView ing_id = (TextView) view.findViewById(R.id.tv_ing_id);

            ingName.setText(name.get(i));
            ing_id.setText("*");

            return view;
        }
    }
}
