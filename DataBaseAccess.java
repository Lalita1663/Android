package com.example.administrator.ingredion4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 4/13/2018.
 */

public class DataBaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DataBaseAccess instance;


    private DataBaseAccess(Context context){

        this.openHelper = new DatabaseHelper(context);


    }


    public static DataBaseAccess getInstance(Context context) {
        if(instance == null)

        {
        //this.database= this.getWritableDatabase();
        instance= new DataBaseAccess(context);
    }
        return instance;
    }

    public void open(){

        this.database=openHelper.getReadableDatabase();}

    public void close(){
        if(database!=null){this.database.close();}
    }

    public void getDish(String name,StringBuilder tv1,StringBuilder tv2,StringBuilder tv3,StringBuilder tv4,StringBuilder tv5,StringBuilder tv6,StringBuilder tv7) {

        String sql = "select * from dish where dish_name = '" + name + "'";
        int dish_id = 0;
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            dish_id=(int)cursor.getInt(0);

            tv1.append(cursor.getString(1));

            cursor.moveToNext();

        }

        sql ="select * from ingo_dish where dish_id = '"+ dish_id +"'  ";
        cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        int cont=0;
        while (!cursor.isAfterLast()) {




            int ing_id =cursor.getInt(2);

            String sql2 = "select ing_name from Ingredients where ing_id = '" + ing_id + "'";
            Cursor cursor2 = database.rawQuery(sql2, null);
            cursor2.moveToFirst();

            switch (cont)
            {
                case 0:
                     tv2.append(cursor2.getString(0));
                    break;
                case 1:
                    tv3.append(cursor2.getString(0));
                    break;
                case 2:
                    tv4.append(cursor2.getString(0));
                    break;
                case 3:
                    tv5.append(cursor2.getString(0));
                    break;
                case 4:
                    tv6.append(cursor2.getString(0));
                    break;
                case 5:
                    tv7.append(cursor2.getString(0));
                    break;


            }


            cont++;
            cursor.moveToNext();

        }






        cursor.close();
    }


    public void getList(ArrayList<String> name, StringBuilder tv1, StringBuilder tv2, StringBuilder tv3, StringBuilder tv4, StringBuilder tv5, StringBuilder tv6, StringBuilder tv7) {


        String temp;
        for (int i=0; i<name.size();i++){
            temp= name.get(i);
            String sql = "select * from dish where dish_name = '" + temp + "'";
            int dish_id = 0;
            Cursor cursor = database.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {


                dish_id=(int)cursor.getInt(0);


                tv5.append(dish_id);

/*
                                                    String sql2 = "select ing_id from ingo_dish where dish_id = '" + dish_id + "'";
                                                    int dish_id2 = 0;
                                                    Cursor cursor2 = database.rawQuery(sql2, null);
                                                    cursor2.moveToFirst();
                                                    while (!cursor2.isAfterLast()) {


                                                        dish_id2=(int)cursor2.getInt(0);


                                                        tv5.append(dish_id2);





                                                        cursor2.moveToNext();

                                                    }

*/



                cursor.moveToNext();

            }

        }
    }





    public void getIngredient(StringBuilder name){

        String sql="select * from Ingredients";
        Cursor cursor = database.rawQuery(sql,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            name.append(cursor.getString(0));
            name.append(") ");
            name.append(cursor.getString(1));
            name.append("     ");
            cursor.moveToNext();
        }
        cursor.close();
    }


    public void getIngredientList(ArrayList<String> ingoList,ArrayList<String >ingoListid) {
        String sql = "select * from Ingredients";

        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            ingoListid.add(cursor.getString(0));
            ingoList.add(cursor.getString(1));
            cursor.moveToNext();

        }
    }

    public void getDishList(ArrayList<String> dishList) {
        String sql = "select dish_name from dish";

        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            dishList.add(cursor.getString(0));
            cursor.moveToNext();

        }
    }

    public void getDish2(String name, ArrayList<String> dishList) {
        String sql = "select * from dish where dish_name = '" + name + "'";
        int dish_id = 0;
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            dish_id=(int)cursor.getInt(0);


            dishList.add(cursor.getString(1));
            cursor.moveToNext();

        }

        sql ="select * from ingo_dish where dish_id = '"+ dish_id +"'  ";
        cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {




            int ing_id =cursor.getInt(2);

            String sql2 = "select ing_name from Ingredients where ing_id = '" + ing_id + "'";
            Cursor cursor2 = database.rawQuery(sql2, null);
            cursor2.moveToFirst();

            dishList.add(cursor2.getString(0));



            cursor.moveToNext();

        }






        cursor.close();

    }

    public void InsertIntoList(ArrayList<String> record,StringBuilder sql) {

        String eventName,date, nop;
        eventName = record.get(0);
        nop = record.get(1);
        date = record.get(2);

      //  eventName = "brown rice";
        String sql2 ="insert into list(list_name,nop,date) values('"+eventName+"','"+nop+"','"+date+"');";
      //  String sql2 ="insert into Ingredients(ing_name) values('"+eventName+"');";
        sql.append(sql2);
        database.execSQL(sql2);

       // Cursor cursor = database.rawQuery(sql,null);
    }

    public void getDishIDS(ArrayList<String> dishList, String s) {
        String sql = "select dish_id from dish where dish_name = '"+s+"'";

        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            dishList.add(cursor.getString(0));
            cursor.moveToNext();

        }

    }

    public void getIngIDS(ArrayList<String> ingList, ArrayList<String> dishID, StringBuilder v) {
        String dish_id = dishID.get(0);
        String sql = "select  ing_id from ingo_dish where dish_id = '"+dish_id+"'";
        v.append(sql);
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            ingList.add(cursor.getString(0));
            cursor.moveToNext();

        }
    }

    public void getIngNames(String ingList, StringBuilder v, ArrayList<String> ingNameList) {
        String ing_id = ingList;
        String sql = "select  ing_name from Ingredients where ing_id = '"+ing_id+"'";
        v.append(sql);
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            ingNameList.add(cursor.getString(0));
            cursor.moveToNext();

        }

    }

    public void getIngQty(String s, StringBuilder v, ArrayList<String> ingQty, String s1) {
        String ing_id = s;
        String sql = "select  ind_qty from ingo_dish where ing_id = '"+ing_id+"' and dish_id = '"+s1+"'" ;
        v.append(sql);
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            ingQty.add(cursor.getString(0));
            cursor.moveToNext();

        }

    }

    public void getListInfo(ArrayList<String > ListDetails) {

        String sql = "select  * from list" ;

        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            ListDetails.add(cursor.getString(0));

            cursor.moveToNext();

        }
    }

    public void getListIDD(ArrayList<String> event, StringBuilder v1) {
        int nop= Integer.parseInt(event.get(1));
        String sql = "select  list_id from list where list_name = '"+event.get(0)+"'and nop = "+nop+" and date = '"+event.get(2)+"'" ;

        //v1.append(sql);
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
       while (!cursor.isAfterLast()) {
           v1.append(cursor.getString(0));

           cursor.moveToNext();
       }

    }

    public void getINGID(String name, StringBuilder v3) {

        String sql = "select  dish_id from dish where dish_name = '"+name+"'";
        //v3.append(sql);
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            v3.append(cursor.getString(0));
            cursor.moveToNext();

        }
    }

    public void InsetListDish(StringBuilder v3, StringBuilder v1, StringBuilder v) {




        String sql2 ="insert into dish_list(dish_id,list_id) values("+v1+","+v3+");";
        //v.append(sql2);
        database.execSQL(sql2);

    }

    public void getINGIDDD(String s, StringBuilder v3, String s1) {
        String sql = "select  ing_id from Ingredients where ing_name = '"+s+"'";
       // v3.append(sql);
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {


            v3.append(cursor.getString(0));
            cursor.moveToNext();

        }
    }

    public void InserIngList(StringBuilder v1, StringBuilder v3, String s,StringBuilder v) {
        String sql2 ="insert into ing_list(list_id,ing_id,ing_qty) values("+v1+","+v3+","+s+");";
        ///v.append(sql2);
        database.execSQL(sql2);
    }
}













