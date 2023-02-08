package com.example.administrator.ingredion4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListIntermidiate extends AppCompatActivity {
    public Button cnew;
    public Button show;

    ArrayList<String > ListDetails = new ArrayList<String >();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_intermidiate);
        cnew= (Button) findViewById(R.id.makenewwwlist);
        cnew.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent toy1  = new Intent(ListIntermidiate.this,ListOpening.class);
                startActivity(toy1);
            }
        });

       // show= (Button) findViewById(R.id.lnname);
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               String s = String.valueOf(show.getText());
                Toast.makeText(getApplicationContext(), ""+s+"", Toast.LENGTH_SHORT).show();
            }
        });

        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);

        databaseAccess.open();
        databaseAccess.getListInfo(ListDetails);
        databaseAccess.close();

        ListView listView=(ListView) findViewById(R.id.showAllLists);

        CustomAdapter customAdapter = new CustomAdapter(ListDetails);
        listView.setAdapter(customAdapter);
       // Toast.makeText(getApplicationContext(), ""+ListDetails+"", Toast.LENGTH_SHORT).show();


    }
    public void setListDetails()
    {
        Intent toy1  = new Intent(ListIntermidiate.this,SavedList2.class);
        TextView listID =(TextView) findViewById(R.id.lnname);
        String s = String.valueOf(listID);
        toy1.putExtra("ListID",s);
        Toast.makeText(getApplicationContext(), ""+s+"", Toast.LENGTH_SHORT).show();
       // startActivity(toy1);

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
            view = getLayoutInflater().inflate(R.layout.customshow_all_lists,null);
            Button namme = (Button) view.findViewById(R.id.lnname);




            namme.setText(name.get(i));


            return view;
        }
    }
}
