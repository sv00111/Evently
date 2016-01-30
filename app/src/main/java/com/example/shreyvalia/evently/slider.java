package com.example.shreyvalia.evently;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class slider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
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


        Firebase.setAndroidContext(this);
        //firebase ref
        Firebase myFirebaseRef = new Firebase("https://eventlyforthehack.firebaseio.com/");


        //Code start here
        ListView eventListView = (ListView)findViewById(R.id.eventList);

        //ArrayList of maps
        List eventList = new ArrayList();
        //New event map
        Map eventMap = new HashMap();
        eventMap.put("title", "Hackathon");
        eventMap.put("date", "1/29/2016");
        eventList.add(eventMap);
        //New event map
        eventMap = new HashMap();
        eventMap.put("title", "Naked Run");
        eventMap.put("date", "1/29/2016");
        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "Whatever");
        eventMap.put("date", "1/29/2016");
        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "Sup");
        eventMap.put("date", "1/29/2016");
        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "Yo");
        eventMap.put("date", "1/29/2016");
        eventList.add(eventMap);

        String[] eventTitle = new String[eventList.size()];
        String[] eventDate = new String[eventList.size()];
        for (int i = 0; i < eventList.size(); i ++){
            Map eventObject = (HashMap) eventList.get(i);
            eventTitle[i] = (String) eventObject.get("title");
            eventDate [i] = (String) eventObject.get("date");
            System.out.println(eventTitle[i].toString());
        }

        //Display strings array events.
        ListAdapter eventAdapter = new customAdaptor(this, eventTitle, eventDate);

        eventListView.setAdapter(eventAdapter);

    }

}
