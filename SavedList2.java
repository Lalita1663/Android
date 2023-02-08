package com.example.administrator.ingredion4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SavedList2 extends AppCompatActivity {
    String listID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_list2);
        listID = String.valueOf(getIntent().getStringArrayListExtra("ListID"));
        Toast.makeText(getApplicationContext(), ""+listID+"", Toast.LENGTH_SHORT).show();
    }
}
