package com.example.shreyvalia.evently;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yuyou on 1/29/2016.
 */
public class customAdaptor extends ArrayAdapter<String> {
    String[] events = {};
    String[] dates = {};

    customAdaptor(Context context, String[] events, String[] dates) {
        super(context, R.layout.custom_row, events);

        this.events = events;
        this.dates = dates;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater customInflater = LayoutInflater.from(getContext());
        View customView = customInflater.inflate(R.layout.custom_row, parent, false);

        //String singleEvent = getItem(position);
        //String singleDate = getItem(position);
        TextView eventText = (TextView) customView.findViewById(R.id.eventTitle);
        TextView eventDate = (TextView) customView.findViewById(R.id.eventDate);
        ImageButton upvoteBtn = (ImageButton) customView.findViewById(R.id.upvote);
        ImageButton downvoteBtn = (ImageButton) customView.findViewById(R.id.downvote);

        eventText.setText(events[position]);
        eventDate.setText(dates[position]);
        upvoteBtn.setImageResource(R.drawable.up);
        downvoteBtn.setImageResource(R.drawable.down);

        return customView;
    }

}