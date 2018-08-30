package com.amin.god.essentialgrammerinuse;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.alespero.expandablecardview.ExpandableCardView;

import java.io.FileOutputStream;

public class UnitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_activity);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        int unit_number = getIntent().getIntExtra("unit_number",1);

        ExpandableCardView acard = findViewById(R.id.a);
        acard.setOnExpandedListener((v, isExpanded) -> {

            String filename = "a.txt";
            String fileContents = "Hello world!";
            FileOutputStream outputStream;

            try {
                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(fileContents.getBytes());
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
