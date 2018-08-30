package com.amin.god.essentialgrammerinuse;

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
//            Toast.makeText(UnitActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show()
            TextView te = ((TextView) findViewById(R.id.content_text));
            te.setText(R.string.action_settings);


        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
