package com.example.tsf_bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class SelectReciever extends AppCompatActivity {
    private RecyclerView myrecycleview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_reciever);
        configureToolbar();

        myrecycleview = findViewById(R.id.recycleview1);
        myrecycleview.setHasFixedSize(true);
        myrecycleview.setLayoutManager(new LinearLayoutManager(this));


        DbSupport dbSupport = new DbSupport(this);
        List<MemberImport> memberImports = dbSupport.getMember();
        if (memberImports.size() > 0){
            Toast.makeText(this, "got the data", Toast.LENGTH_SHORT).show();
            Recycleadapter1 recycleadapter1 = new Recycleadapter1(memberImports,SelectReciever.this);
            myrecycleview.setAdapter(recycleadapter1);
        }else {
            Toast.makeText(this, "there is no data to show", Toast.LENGTH_SHORT).show();
        }








    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbarmenu,menu);
        return true;
    }


    private void configureToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Details");

    }
}