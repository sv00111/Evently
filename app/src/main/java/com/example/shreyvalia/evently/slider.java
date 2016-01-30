package com.example.shreyvalia.evently;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

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
        Firebase myFirebaseRef = new Firebase("https://blistering-torch-7311.firebaseio.com/");

        //Code start here
        ListView eventListView = (ListView)findViewById(R.id.eventList);

        //ArrayList of maps
        List eventList = new ArrayList();
        //New event map
        Map eventMap = new HashMap();
        eventMap.put("title", "Hackathon");
        eventMap.put("date", "1/29/2016");
        eventMap.put("voteCount", "25");
        eventMap.put("description", "Come hack in UCSC. Free redbull included.");
        eventList.add(eventMap);
        //New event map
        eventMap = new HashMap();
        eventMap.put("title", "Naked Run");
        eventMap.put("date", "1/30/2016");
        eventMap.put("voteCount", "15");
        eventMap.put("description", "Take off your clothes");
        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "Whatever");
        eventMap.put("date", "1/31/2016");
        eventMap.put("voteCount", "-1");
        eventMap.put("description", "Yea.");

        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "Sup");
        eventMap.put("date", "1/29/2016");
        eventMap.put("voteCount", "55");
        eventMap.put("description", "Supppp.");
        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "Yo");
        eventMap.put("date", "1/29/2016");
        eventMap.put("voteCount", "99");
        eventMap.put("description", "Ayyyyyyy LMAO.");
        eventList.add(eventMap);

        String[] eventTitle = new String[eventList.size()];
        String[] eventDate = new String[eventList.size()];
        String[] voteCount = new String[eventList.size()];
        String[] description = new String[eventList.size()];
        for (int i = 0; i < eventList.size(); i ++){
            Map eventObject = (HashMap) eventList.get(i);
            eventTitle[i] = (String) eventObject.get("title");
            eventDate [i] = (String) eventObject.get("date");
            voteCount [i] = (String) eventObject.get("voteCount");
            description [i] = (String) eventObject.get("description");
            System.out.println(eventTitle[i].toString());
        }

        //Display strings array events.
        //ListAdapter eventAdapter = new customAdaptor(this, eventTitle, eventDate, voteCount, description);

        //eventListView.setAdapter(eventAdapter);

        //Make eventListView clickable
        eventListView.setClickable(true);
        //eventListView.setOnItemClickListener(new ListClickHandler());
    }

//    public class ListClickHandler implements OnItemClickListener{
//
//        @Override
//        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
//            System.out.println("tapped");
//            Intent intent = new Intent(getApplicationContext(), details.class);
//            startActivity(intent);
//        }
//
//    }
}
