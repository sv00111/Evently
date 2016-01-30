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

        //Store all displayed text in arrays of string
        String[] eventTitle = new String[eventList.size()];
        String[] eventDate = new String[eventList.size()];
        String[] voteCount = new String[eventList.size()];
        String[] description = new String[eventList.size()];
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
                        intent.putExtra("eventTitle",String.valueOf(parent.getItemAtPosition(position)));
                        intent.putExtra("date",String.valueOf(parent.getItemAtPosition(position)));
                        intent.putExtra("description",String.valueOf(parent.getItemAtPosition(position)));
                        intent.putExtra("address","101 High Street Santa Cruz, CA 95060");
                        startActivity(intent);
                    }
                }
        );
        // Inflate the layout for this fragment
        return rootView;
    }



}
