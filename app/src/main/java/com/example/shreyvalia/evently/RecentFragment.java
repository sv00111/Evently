package com.example.shreyvalia.evently;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecentFragment extends Fragment {

    boolean queryDone = false;
    String[] eventTitle = {};
    String[] eventDate = {};
    String[] voteCount = {};
    String[] description = {};
    View rootView;
    ListView eventListView;

    public RecentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_hot, container, false);

        //Code start here
        eventListView = (ListView) rootView.findViewById(R.id.eventList);

        //ArrayList of maps
        final List eventList = new ArrayList();
        try {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
            query.orderByDescending("createdAt");
            query.findInBackground(new FindCallback<ParseObject>() {
                public void done(List<ParseObject> eventParseList, ParseException e) {
                    if (e == null) {

                        System.out.println("Start Here");
                        Log.d("event", "Retrieved " + eventParseList.size() + " events");
                        for (ParseObject eventObject : eventParseList) {
                            Map eventMap = new HashMap();
                            eventMap.put("title", eventObject.get("eventTitle"));
                            eventMap.put("date", eventObject.get("date"));
                            eventMap.put("voteCount", eventObject.get("voteCount"));
                            eventMap.put("description", eventObject.get("description"));
                            eventList.add(eventMap);
                        }
                        System.out.println(eventList);
                    } else {
                        Log.d("event", "Error: " + e.getMessage());
                    }


                    // this code will be executed after 2 seconds
                    //Store all displayed text in arrays of string
                    eventTitle = new String[eventList.size()];
                    eventDate = new String[eventList.size()];
                    voteCount = new String[eventList.size()];
                    description = new String[eventList.size()];

                    //Populate strings
                    for (int i = 0; i < eventList.size(); i++) {
                        Map eventObject = (HashMap) eventList.get(i);
                        eventTitle[i] = (String) eventObject.get("title");
                        eventDate[i] = (String) eventObject.get("date");
                        voteCount[i] = String.valueOf(eventObject.get("voteCount"));
                        description[i] = (String) eventObject.get("description");
                    }
                    System.out.println(eventTitle);


                    ListAdapter eventAdapter = new customAdaptor(getActivity().getApplicationContext(), eventTitle, eventDate, voteCount, description);
                    eventListView.setAdapter(eventAdapter);

                    eventListView.setOnItemClickListener(
                            new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    //String currentEvent = String.valueOf(parent.getItemAtPosition(position));
                                    //Toast.makeText(getActivity().getApplicationContext(), currentEvent, Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getActivity().getApplicationContext(), detailActivity.class);
                                    intent.putExtra("eventTitle", eventTitle[position]);
                                    intent.putExtra("date", eventDate[position]);
                                    intent.putExtra("description", description[position]);
                                    intent.putExtra("address", "101 High Street Santa Cruz, CA 95060");
                                    startActivity(intent);
                                }
                            }
                    );
                    // Inflate the layout for this fragment

                    //Display strings array events.
                    queryDone = true;
                }
            });
        }catch (Exception e){
            queryDone = true;
        }

        if(queryDone){
            return rootView;
        }else{
            return rootView;
        }
    }
}
