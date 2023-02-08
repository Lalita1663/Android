package com.example.administrator.ingredion4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddIngred extends AppCompatActivity {

    EditText edting;
    Button btning;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingred);
        init();

       // databaseHelper=new DatabaseHelper(this);
        ////databaseHelper.queryData("CREATE TABLE IF NOT EXISTS Ingredient(ing_id INTEGER PRIMARY KEY AUTOINCREMENT, ing_name VARCHAR)");

        btning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //databaseHelper.insertIngredient(
                    //edting.getText().toString().trim()
                    //);
                    Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                    edting.setText("");

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


    }
    public void init(){
        btning=(Button)findViewById(R.id.btning);
        edting=(EditText)findViewById(R.id.edting);

    }

}
