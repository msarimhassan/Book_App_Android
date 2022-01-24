package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        List<String> name_list= new ArrayList<>();
        List<Integer> image_list= new ArrayList<>();
        int[] images = {
                R.drawable.philosopherstone,
                R.drawable.secret,
                R.drawable.prisoner,
                R.drawable.fire,
                R.drawable.phoenix,
                R.drawable.prince,
                R.drawable.deathly
        };
        String [] names={"PhilosopherStone", "ChamberSecret", "PrisonerAzakaban", "GobletFire", "OrderPhoenix", "HalfBloodprince", "DealthlyHallows"};



        //MYURI
        Uri uri=Uri.parse("content://com.example.bookapp.MyContentProvider/Books");
        ContentValues values = new ContentValues();
        for (int i=0;i<images.length;i++)
        {
            values.put("bookname",names[i]);
            values.put("bookimage",images[i]);
            getContentResolver().insert(uri, values);
        }

        Cursor cursor;
        cursor = getContentResolver().query(uri,null,null,null,null);


        while(cursor.moveToNext()){
            name_list.add(cursor.getString(1));
            image_list.add(cursor.getInt(2));
        }

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerViewAdapter(MainActivity3.this,name_list,image_list);
        recyclerView.setAdapter(adapter);
    }
}