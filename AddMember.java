    package com.example.tsf_bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class AddMember extends AppCompatActivity {
         private DbSupport dbSupport ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        configureToolbar();

        EditText etname = (EditText)findViewById(R.id.name);
        EditText etemail = (EditText)findViewById(R.id.emailid);
        EditText etcurrent = (EditText)findViewById(R.id.currentbal);
        EditText etAcc = (EditText)findViewById(R.id.Accno);




        Button b = (Button)findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String strname = etname.getText().toString();
             String stremail = etemail.getText().toString();
             String strcurrent = etcurrent.getText().toString();
             String straccount= etAcc.getText().toString();
             if (strname.length() <=0 || stremail.length() <=0 || strcurrent.length() <=0 || straccount.length() <=0){
                 Toast.makeText(AddMember.this, "zxfczsd", Toast.LENGTH_SHORT).show();
             }else {
              DbSupport dbSupport = new DbSupport(AddMember.this);
              MemberImport memberImport = new MemberImport(strname,stremail,strcurrent,straccount);
              dbSupport.AddMem(memberImport);
                 Toast.makeText(AddMember.this, "member added", Toast.LENGTH_SHORT).show();
                 Intent i = new Intent(AddMember.this,MainActivity.class);
                 startActivity(i);

             }

            }
        });
    }
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            if (item.getItemId()== android.R.id.home){
                Intent i = new Intent(AddMember.this,MainActivity.class);
                startActivity(i);
            }
            return super.onOptionsItemSelected(item);
        }
    private void configureToolbar(){
        Toolbar toolbar = findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add Members");

    }
}