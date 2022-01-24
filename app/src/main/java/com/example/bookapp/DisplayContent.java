package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_content);

        TextView bookname;
        ImageView bookimage;

        bookname=findViewById(R.id.book_name);
        bookimage=findViewById(R.id.image_name);

        Intent intent=getIntent();
        String name=intent.getStringExtra("BOOK_NAME");
        int image=intent.getIntExtra("BOOK_IMAGE",0);

        bookname.setText(name);
        bookimage.setImageResource(image);

        Button close=findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(close.getId()==v.getId()){
                    finish();
                }
            }
        });
    }
}