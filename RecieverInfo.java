package com.example.tsf_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class RecieverInfo extends AppCompatActivity {
    EditText name,email,current,account,senderbal;
    Integer Amount,Amount1,amtosend,amtosend1;
    EditText e1;
    Button del,trans;
    String nametocomp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DbSupport db = new DbSupport(this);
        setContentView(R.layout.activity_reciever_info);
        name=(EditText) findViewById(R.id.nameview);
        name.setEnabled(false);
        email=(EditText) findViewById(R.id.emailview);
        email.setEnabled(false);
        current=(EditText) findViewById(R.id.currentbal);
        current.setEnabled(false);
        account=(EditText) findViewById(R.id.accnoview);
        account.setEnabled(false);

        del=(Button)findViewById(R.id.Delete);
        e1 = (EditText)findViewById(R.id.transam);






        name.setText(getIntent().getStringExtra("Name"));
        email.setText(getIntent().getStringExtra("Email"));
        current.setText(getIntent().getStringExtra("Current"));
        account.setText(getIntent().getStringExtra("Accno"));

        String name1=name.getText().toString();

        String nametocomp=Dailoge1.nameto;




        trans= (Button)findViewById(R.id.moneytransfer);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbSupport dbSupport = new DbSupport(RecieverInfo.this) ;
                amtosend=Integer.parseInt(e1.getText().toString());
                amtosend1=Integer.parseInt(e1.getText().toString());
                Amount=Integer.parseInt(Dailoge1.currentbal);
                Amount1=Integer.parseInt(current.getText().toString());

                Integer Senderam=Amount - amtosend;
                Integer Recievam=Amount1 + amtosend1;

                dbSupport.updateam(name1,Recievam);
                dbSupport.updateam(nametocomp,Senderam);
                Toast.makeText(RecieverInfo.this,Recievam.toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RecieverInfo.this,MainActivity.class);
                startActivity(i);
            }
        });



    }
}