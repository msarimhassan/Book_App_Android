package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button Register;
    EditText name,password,repassword;
    TextView message;
    SharedPreferences shrpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.USERNAME);
        password=findViewById(R.id.PASSWORD);
        repassword=findViewById(R.id.REPASSWORD);
        Register=findViewById(R.id.REGISTER);
        message=findViewById(R.id.MESSAGE);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Register.getId()==v.getId()){

                    if(password.getText().toString().equals(repassword.getText().toString()))
                    {
                        shrpref=getSharedPreferences("MySharePref",MODE_PRIVATE);
                        SharedPreferences.Editor editor=shrpref.edit();
                        editor.putString("USERNAME",name.getText().toString());
                        editor.putString("PASSWORD",password.getText().toString());
                        editor.commit();
                        Toast.makeText(getApplicationContext(),"Registered Succesfully",Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else
                    {
                        message.setText("Password doesn't match");
                    }
                }
            }
        });
    }
}