package com.example.administrator.ingredion4;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectDish extends AppCompatActivity {

    ArrayList<String > selection = new ArrayList<String >();
    ArrayList<String > DishList = new ArrayList<String >();
    ArrayList<String> record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dish);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);

        databaseAccess.open();
        databaseAccess.getDishList(DishList);


        ListView listView=(ListView) findViewById(R.id.select_dish);
         record = getIntent().getStringArrayListExtra("Name");

        StringBuilder v=new StringBuilder();
        v.setLength(0);
        databaseAccess.InsertIntoList(record,v);
       // Toast.makeText(getApplicationContext(), ""+v+"", Toast.LENGTH_SHORT).show();

        CustomAdapter customAdapter = new CustomAdapter(DishList);
        listView.setAdapter(customAdapter);

        databaseAccess.close();
       // record = getIntent().getStringArrayListExtra("Name");
      //  Toast.makeText(getApplicationContext(), ""+selection+"", Toast.LENGTH_SHORT).show();




    }

    public void insert_list_dish(View view) {
        //Toast.makeText(getApplicationContext(), ""+selection+"", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(SelectDish.this,FinalListDisplay.class);
        intent.putExtra("Name",selection);
        intent.putExtra("EventDetail",record);
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
            view = getLayoutInflater().inflate(R.layout.custom_select_dish,null);
            CheckBox ingName = (CheckBox) view.findViewById(R.id.listinstance);


            ingName.setText(name.get(i));

            return view;
        }
    }


    public void Selected_dishes(View view){
        boolean checked = ((CheckBox) view).isChecked();
        String  selcc = (String) ((CheckBox) view).getText();

        if (checked){
            selection.add(selcc);
            // section_dish.add("kheer");
        }
        else {
            selection.remove(selcc);
        }
      //  Toast.makeText(getApplicationContext(), ""+ selection +"", Toast.LENGTH_SHORT).show();
    }



    public void FinalSelection(View view) {

        /*
        String final_dish_selection = "";
        for (String Selections : selection){
            Toast.makeText(getApplicationContext(), ""+selection.size()+"", Toast.LENGTH_SHORT).show();
            final_dish_selection = selection + "\n";
        }
        final_text.setText(final_dish_selection);
        //final_text.setText(()final_text[0]);
        final_text.setEnabled(true);
        */

        Bundle extras = new Bundle();
        extras.putStringArrayList("Name",selection);
        extras.putStringArrayList("EventDetail", record);

        Intent intent=new Intent(SelectDish.this,FinalListDisplay.class);
        intent.putExtras(extras);
       // intent.putExtra("EventDetail",record);
       // Toast.makeText(getApplicationContext(), ""+selection+"", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

}

