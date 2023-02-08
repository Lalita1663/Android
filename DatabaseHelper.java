package com.example.administrator.ingredion4;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 4/13/2018.
 */

public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "ingo.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase myDatabase;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor QueryData(String query) throws SQLException{
        return myDatabase.rawQuery(query,null);
    }




   /* private final Context mycontext;

    private String DB_PATH = "/data/data/com.example.administrator.ingredion4/database/";
    private static String DB_NAME = "ingredion.db";







    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try {
            String mypath  = DB_PATH+DB_NAME;
            checkDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);

        }catch (SQLException e){

        }
        if (checkDB != null) checkDB.close();
        return checkDB != null ? true : false;
    }

    private void copyDatabase() throws IOException{
        InputStream myInput = mycontext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH+DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length= myInput.read(buffer)) > 0){
            myOutput.write(buffer,0,length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDatabase() throws SQLException{
        String myPath = DB_PATH+DB_NAME;

        myDatabase = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.CREATE_IF_NECESSARY);

    }
    public void ExeSQLData(String sql) throws SQLException{
        myDatabase.execSQL(sql);
    }



    @Override
    public synchronized void close() {
        if (myDatabase != null)
            myDatabase.close();
        super.close();
    }

    public void checkAndCopyDatabase(){
        boolean dbExist = checkDataBase();
        if (dbExist)
        {
            Log.d("TAG","Database already exist");
        }
        else {

            this.getReadableDatabase();
            try {
                copyDatabase();
            }catch (IOException e)
            {
                Log.d("TAG","Error copying Database");
            }
        }
    }

    */
}
