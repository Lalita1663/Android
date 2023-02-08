package com.example.administrator.ingredion4;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FinalListDisplay extends AppCompatActivity {

    ArrayList<String > DishList = new ArrayList<String >();
    ArrayList<String > IngList = new ArrayList<String >();
    ArrayList<String > IngNameList = new ArrayList<String >();
    ArrayList<String > IngNameListWithoutRepttn = new ArrayList<String >();
    ArrayList<String > IngQty = new ArrayList<String >();
    ArrayList<String> event;
    ArrayList<String> name;
    ArrayList<String > FfIngQty;
    Button save;

    ArrayList<String> Duplic = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_list_display);

        ListView listView=(ListView) findViewById(R.id.listview);
        //Intent intent = getIntent();
       // Bundle extras = intent.getExtras();

     //   ArrayList<String > name  = extras.getStringArrayList("Name");

       name = getIntent().getStringArrayListExtra("Name");  //dhish names
        event = getIntent().getStringArrayListExtra("EventDetail");
      //  ArrayList<String> event = extras.getStringArrayList("EventDetail"); //eventName

       // Toast.makeText(getApplicationContext(), ""+event+"", Toast.LENGTH_SHORT).show();


     //   Toast.makeText(getApplicationContext(), ""+name+"", Toast.LENGTH_SHORT).show();

        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);

        databaseAccess.open();
        StringBuilder v1=new StringBuilder();
        v1.setLength(0);
        databaseAccess.getListIDD(event,v1);

     //   Toast.makeText(getApplicationContext(), ""+v1+"", Toast.LENGTH_SHORT).show(); //list id
        for (int i=0; i<name.size() ; i++){
            StringBuilder v3=new StringBuilder();
            v3.setLength(0);
            databaseAccess.getINGID(name.get(i),v3);


            StringBuilder v4=new StringBuilder();
            v4.setLength(0);
            databaseAccess.InsetListDish(v1,v3,v4);
           // Toast.makeText(getApplicationContext(), ""+v4+"", Toast.LENGTH_SHORT).show(); //list id
            v3.setLength(0);

        }


       // v1.setLength(0);

       //
        for (int i=0; i<name.size() ; i++){
            databaseAccess.getDishIDS(DishList,name.get(i));
          //  Toast.makeText(getApplicationContext(), ""+DishList.get(0)+"", Toast.LENGTH_SHORT).show();
            StringBuilder v=new StringBuilder();
            v.setLength(0);

            databaseAccess.getIngIDS(IngList,DishList,v);
          //  Toast.makeText(getApplicationContext(), ""+IngList+"", Toast.LENGTH_SHORT).show();
            v.setLength(0);
            for(int t=0; t<IngList.size();t++){
                Duplic.add(IngList.get(t));
            }
            //Duplic += IngList;

            for (int j =0; j<IngList.size() ; j++)
            {
                databaseAccess.getIngNames(IngList.get(j),v,IngNameList);
                //v.setLength(0);




                databaseAccess.getIngQty(IngList.get(j),v,IngQty,DishList.get(0));
              //  Toast.makeText(getApplicationContext(), ""+v+"", Toast.LENGTH_SHORT).show();


                v.setLength(0);
            }

            DishList.clear();
            IngList.clear();

        }
       // getDuplicates(IngList);
       // Toast.makeText(getApplicationContext(), ""+IngNameList+"", Toast.LENGTH_SHORT).show();

      //  Toast.makeText(getApplicationContext(), ""+Duplic+"", Toast.LENGTH_SHORT).show();

        for (int i=0; i<IngNameList.size(); i++)
        {
            if(!(IngNameListWithoutRepttn.contains(IngNameList.get(i)))){
                IngNameListWithoutRepttn.add(IngNameList.get(i));
               // Toast.makeText(getApplicationContext(), "New added "+IngNameListWithoutRepttn+"", Toast.LENGTH_LONG).show();
            }
            //else Toast.makeText(getApplicationContext(), "Not added since alredy exist", Toast.LENGTH_LONG).show();
        }
      //  Toast.makeText(getApplicationContext(), ""+IngNameList+"", Toast.LENGTH_LONG).show();
      //  Toast.makeText(getApplicationContext(), ""+IngQty+"", Toast.LENGTH_SHORT).show();
        int siz = IngQty.size() -  IngNameListWithoutRepttn.size() ;
        for(int t=0; t<siz;t++){
            IngQty.remove(IngQty.size()-1);
        }

       // Toast.makeText(getApplicationContext(), ""+IngQty+"", Toast.LENGTH_SHORT).show();
        ArrayList<Integer> fIngQty = new ArrayList<Integer>();
        FfIngQty = new ArrayList<String >();

        for (int f=0; f<IngQty.size(); f++){
            int qtyy = Integer.parseInt(IngQty.get(f));
            int mulnop= Integer.parseInt(event.get(1));
            int fqty = qtyy*mulnop;
            fIngQty.add(fqty);
        }

        for (int f=0; f<IngQty.size(); f++){
            String qtyy = String.valueOf(fIngQty.get(f));

            FfIngQty.add(qtyy);
        }


        //IngQty = fIngQty;


        //Toast.makeText(getApplicationContext(), ""+fIngQty+"", Toast.LENGTH_SHORT).show();
       // *event.get(1)
        CustomAdapter customAdapter = new CustomAdapter(IngNameListWithoutRepttn,FfIngQty);
        listView.setAdapter(customAdapter);

        databaseAccess.close();





    }

    public void insert_list(View view) {


        DataBaseAccess databaseAccess= DataBaseAccess.getInstance(this);;
        databaseAccess.open();
        StringBuilder v1=new StringBuilder();
        v1.setLength(0);
        databaseAccess.getListIDD(event,v1);

        //   Toast.makeText(getApplicationContext(), ""+v1+"", Toast.LENGTH_SHORT).show(); //list id
        for (int i=0; i<name.size() ; i++){
            StringBuilder v3=new StringBuilder();
            v3.setLength(0);
            databaseAccess.getINGID(name.get(i),v3);


            StringBuilder v4=new StringBuilder();
            v4.setLength(0);
            databaseAccess.InsetListDish(v1,v3,v4);
            //
            v3.setLength(0);

        }
      //  EditText

        for (int i=0; i<IngNameListWithoutRepttn.size() ; i++){
            StringBuilder v3=new StringBuilder();
            v3.setLength(0);
            databaseAccess.getINGIDDD(IngNameListWithoutRepttn.get(i),v3,FfIngQty.get(i));


            //v3 ingId v1 list id
            StringBuilder v=new StringBuilder();
            v.setLength(0);
            databaseAccess.InserIngList(v1,v3,FfIngQty.get(i),v);
          //  Toast.makeText(getApplicationContext(), ""+v+"", Toast.LENGTH_SHORT).show(); //list id
            v3.setLength(0);
        }
        databaseAccess.close();


        Intent intent=new Intent(FinalListDisplay.this,SavedList.class);
        intent.putExtra("Name",name);
        intent.putExtra("EventDetail",event);
        intent.putExtra("ingNames",IngNameListWithoutRepttn);
        intent.putExtra("Qty",FfIngQty);


        startActivity(intent);
    }



    class CustomAdapter extends BaseAdapter{

        ArrayList<String> name;
        ArrayList<String > qty;

        public CustomAdapter(ArrayList<String> name, ArrayList<String > ingQty) {
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
            view = getLayoutInflater().inflate(R.layout.custom_layout,null);
            TextView ingName = (TextView) view.findViewById(R.id.ingName);
            EditText ingQty = (EditText) view.findViewById(R.id.ingQty);

            ingName.setText(name.get(i));
           // int qtyy = ingQty;
            ingQty.setText(qty.get(i));

            return view;
        }
    }

    public <T extends Comparable<T>> void getDuplicates(ArrayList<String> array) {
        Set<T> dupes = new HashSet<T>();
        for (String i : array) {
            if (!dupes.add((T) i)) {
                //System.out.println("Duplicate element in array is : " + i);
                Toast.makeText(getApplicationContext(), ""+i+"", Toast.LENGTH_LONG).show();
            }
        }
    }


}
