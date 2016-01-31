package com.example.shreyvalia.evently;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment {

    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hot, container, false);

        //Code start here
        ListView eventListView = (ListView) rootView.findViewById(R.id.eventList);

        //ArrayList of maps
        List eventList = new ArrayList();
        //New event map
        Map eventMap = new HashMap();
        eventMap.put("title", "HACKUCSC");
        eventMap.put("date", "January 30, 2016");
        eventMap.put("voteCount", "25");
        eventMap.put("description", "Come hack in UCSC! First place winner gets ...");
        eventList.add(eventMap);
        //New event map
        eventMap = new HashMap();
        eventMap.put("title", "Volunteer Day! ");
        eventMap.put("date", "July 26, 2016");
        eventMap.put("voteCount", "15");
        eventMap.put("description", "Come join UC Santa Cruz in it's annual volunteer ...");
        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "Arts and Crafts! ");
        eventMap.put("date", "June 25, 2016");
        eventMap.put("voteCount", "5");
        eventMap.put("description", "Come and learn the basics of DIY crafts and knitting ...");

        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "STEM Innovation Bowl");
        eventMap.put("date", "January 30, 2016");
        eventMap.put("voteCount", "4");
        eventMap.put("description", "Science and technology by The Santa Clara Library and Inf ...");
        eventList.add(eventMap);

        eventMap = new HashMap();
        eventMap.put("title", "2016 Super Bowl");
        eventMap.put("date", "Feburary 7, 2016");
        eventMap.put("voteCount", "2");
        eventMap.put("description", "Sign up for Our VIP Guest List for a chance to win Super Bowl Game ...");
        eventList.add(eventMap);

        //Store all displayed text in arrays of string
        final String[] eventTitle = new String[eventList.size()];
        final String[] eventDate = new String[eventList.size()];
        final String[] voteCount = new String[eventList.size()];
        final String[] description = new String[eventList.size()];
        //loop through all array to display all events and details
        for (int i = 0; i < eventList.size(); i ++){
            Map eventObject = (HashMap) eventList.get(i);
            eventTitle[i] = (String) eventObject.get("title");
            eventDate [i] = (String) eventObject.get("date");
            voteCount [i] = (String) eventObject.get("voteCount");
            description [i] = (String) eventObject.get("description");
        }

        //Display strings array events.
        ListAdapter eventAdapter = new customAdaptor(getActivity().getApplicationContext(), eventTitle, eventDate, voteCount, description);

        eventListView.setAdapter(eventAdapter);

        eventListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        //String currentEvent = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(getActivity().getApplicationContext(), currentEvent, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getActivity().getApplicationContext(), detailActivity.class);
                        intent.putExtra("eventTitle",eventTitle[position]);
                        intent.putExtra("date",eventDate[position]);
                        intent.putExtra("description",description[position]);
                        intent.putExtra("address","101 High Street Santa Cruz, CA 95060");
                        startActivity(intent);
                    }
                }
        );
        // Inflate the layout for this fragment
        return rootView;
    }



}
