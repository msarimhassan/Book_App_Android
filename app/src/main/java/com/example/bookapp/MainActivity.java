package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Signup,Login;
    SharedPreferences shrpref;
    TextView message;
    EditText edt1,edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Signup=findViewById(R.id.SIGNUP);
        Login=findViewById(R.id.LOGIN);
        message=findViewById(R.id.MESSAGE);
        edt1=findViewById(R.id.USERNAME);
        edt2=findViewById(R.id.PASSWORD);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Signup.getId()==v.getId()){

                    Intent intent= new Intent(MainActivity.this,MainActivity2.class);

                    startActivity(intent);
                }
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Login.getId()==v.getId()){
                    shrpref=getSharedPreferences("MySharePref",MODE_PRIVATE);
                    String Username=shrpref.getString("USERNAME","null");
                    String Password=shrpref.getString("PASSWORD","null");
                    if(Username.equals(edt1.getText().toString())&&Password.equals(edt2.getText().toString())){

                        // working of login
                        Intent intent2=new Intent(MainActivity.this,MainActivity3.class);
                        startActivity(intent2);

                   }
                    else{
                        message.setText("Wrong Username or password");
                    }
                }
            }
        });

    }
}