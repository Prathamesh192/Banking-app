package com.example.tsf_bank;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView myrecycleview;
    private RecyclerView.Adapter myadapter;
    private RecyclerView.LayoutManager myLayoutmanager;
    DbSupport dbSupport;
    final String data = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureToolbar();

        myrecycleview = findViewById(R.id.recycleview);
        myrecycleview.setHasFixedSize(true);
         myrecycleview.setLayoutManager(new LinearLayoutManager(this));


        DbSupport dbSupport = new DbSupport(this);
        List<MemberImport> memberImports = dbSupport.getMember();
        if (memberImports.size() > 0){
            Toast.makeText(this, "got the data", Toast.LENGTH_SHORT).show();
            Recycleadapter recycleadapter = new Recycleadapter(memberImports,MainActivity.this);
            myrecycleview.setAdapter(recycleadapter);
        }else {
            Toast.makeText(this, "there is no data to show", Toast.LENGTH_SHORT).show();
        }







        FloatingActionButton fb = findViewById(R.id.floatingbutton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AddMember.class);
                startActivity(i);
            }
        });
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
        actionBar.setTitle("Bank Members");

    }


}