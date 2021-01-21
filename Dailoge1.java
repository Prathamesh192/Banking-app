package com.example.tsf_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dailoge1 extends AppCompatActivity {
EditText name,email,current,account;
String id = null;
Integer idinint;
Button del,trans;
public static String currentbal;
    public static String nameto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       DbSupport db = new DbSupport(this);
        setContentView(R.layout.activity_dailoge1);
        name=(EditText) findViewById(R.id.name);
        name.setEnabled(false);
        email=(EditText) findViewById(R.id.emailid);
        email.setEnabled(false);
        current=(EditText) findViewById(R.id.currentbal);
        current.setEnabled(false);
        account=(EditText) findViewById(R.id.Accno);
        account.setEnabled(false);
        del=(Button)findViewById(R.id.Delete);






        name.setText(getIntent().getStringExtra("Name"));
        email.setText(getIntent().getStringExtra("Email"));
        current.setText(getIntent().getStringExtra("Current"));
        account.setText(getIntent().getStringExtra("Accno"));
        trans= (Button)findViewById(R.id.moneytransfer);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dailoge1.this,SelectReciever.class);
                startActivity(i);
            }
        });

        Dailoge1.currentbal = current.getText().toString();
        Dailoge1.nameto = name.getText().toString();

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String delerows = name.getText().toString();
                Boolean checkdeldata = db.Delmem(delerows);
                if(checkdeldata == true){
                    Toast.makeText(Dailoge1.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Dailoge1.this,MainActivity.class);
                    startActivity(i);

                }else{
                    Toast.makeText(Dailoge1.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}