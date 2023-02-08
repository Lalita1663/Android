package com.example.administrator.ingredion4;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 4/13/2018.
 */

public class Adapter extends ArrayAdapter<ingredient> {
    private Activity activity;
    int id;

    ArrayList<ingredient> ingredients;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView=inflater.inflate(id,null);
        }
        ingredient ingredient = ingredients.get(position);
        TextView tv_ing_id = (TextView) convertView.findViewById(R.id.tv_ing_id);
        TextView tv_ing_name= (TextView) convertView.findViewById(R.id.tv_ing_name);

        tv_ing_id.setText(ingredient.getIng_id());
        tv_ing_name.setText(ingredient.getIng_name());

        return convertView;
    }

    public Adapter(@NonNull Activity context, int resource, @NonNull ArrayList<ingredient> objects) {
        super(context, resource, objects);
        this.activity=context;
        this.id=resource;
        this.ingredients=objects;

    }
}
