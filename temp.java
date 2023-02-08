package com.example.administrator.ingredion4;

import android.database.SQLException;
import android.widget.Toast;

/**
 * Created by Administrator on 4/14/2018.
 */

public class temp {

    /*
    public class ViewIngred extends AppCompatActivity {

    ListView listView;
    private DatabaseHelper dbHelper;
    Adapter adapter;
    ArrayList<ingredient> arrayList = new ArrayList<ingredient>();
    public  TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ingred);//en_US


        /* //phonebook method
        tv1=(TextView)findViewById(R.id.tv1);*/
    //StringBuilder v1=new StringBuilder();
    //v1.setLength(0);
       /* DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);
        try {
            databaseAccess.open();


            Toast.makeText(getApplicationContext(), "This is working!", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){
            Toast.makeText(getApplicationContext(), "crap!", Toast.LENGTH_SHORT).show();
        }
        */


/*
    //loadDataBase

    dbHelper=new DatabaseHelper(this);
    DataBaseAccess databaseAccess = DataBaseAccess.getInstance(this);
        try {
        databaseAccess.open();

        databaseAccess.close();
        Toast.makeText(getApplicationContext(), "This is working!", Toast.LENGTH_SHORT).show();
    }
        catch (SQLException e){
        Toast.makeText(getApplicationContext(), "crap!", Toast.LENGTH_SHORT).show();
    }
//        databaseAccess.close();





        try {
        dbHelper.checkAndCopyDatabase();   //error
        dbHelper.openDatabase();  //error this is not working
        Toast.makeText(getApplicationContext(), "This is working!", Toast.LENGTH_SHORT).show();
    }catch (SQLException e){
        Toast.makeText(getApplicationContext(), "crap!", Toast.LENGTH_SHORT).show();
    }

*/

/*        try {
            Cursor cursor= dbHelper.QueryData("SELECT * FROM Ingredient");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {

                        ingredient Ingrd = new ingredient();
                        Ingrd.setIng_id(cursor.getString(0));
                        Ingrd.setIng_name(cursor.getString(1));
                        arrayList.add(Ingrd);
                    } while (cursor.moveToNext());
                }
            }
        }catch (SQLException e){

        }



        adapter = new Adapter(this,R.layout.custom_list_item,arrayList);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        */
/*
}
}public class ViewIngred extends SQLiteAssetHelper {

    ListView listView;
    private DatabaseHelper dbHelper;
    Adapter adapter;
    ArrayList<ingredient> arrayList = new ArrayList<ingredient>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ingred);




        //loadDataBase






        try {
            dbHelper.checkAndCopyDatabase();
            dbHelper.openDatabase();
            Toast.makeText(getApplicationContext(), "This is working!", Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), "crap!", Toast.LENGTH_SHORT).show();
        }


/*
     try {
            Cursor cursor= dbHelper.QueryData("SELECT * FROM Ingredients");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {

                        ingredient Ingrd = new ingredient();
                        Ingrd.setIng_id(cursor.getString(0));
                        Ingrd.setIng_name(cursor.getString(1));
                        arrayList.add(Ingrd);
                    } while (cursor.moveToNext());
                }
            }
        }catch (SQLException e){

        }



        adapter = new Adapter(this,R.layout.custom_list_item,arrayList);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

*/
/*
}
}

        */
}
