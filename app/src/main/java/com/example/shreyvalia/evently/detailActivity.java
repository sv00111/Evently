package com.example.shreyvalia.evently;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView eventText = (TextView)findViewById(R.id.eventTitle);
        TextView dateText = (TextView)findViewById(R.id.dateTime);
        TextView addressText = (TextView)findViewById(R.id.address);
        TextView descriptionText = (TextView)findViewById(R.id.description);
        Intent intent = getIntent();
        if (null != intent) {
            String eventTitle = intent.getStringExtra("eventTitle");
            eventText.setText(eventTitle);
            String date = intent.getStringExtra("date");
            eventText.setText(date);
            String address = intent.getStringExtra("address");
            eventText.setText(address);
            String description = intent.getStringExtra("description");
            eventText.setText(description);
        }
    }

}
