package com.example.shreyvalia.evently;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Yuyou on 1/30/2016.
 */
public class customAdaptorSelf extends ArrayAdapter<String> {
    String[] events = {};
    String[] dates = {};

    customAdaptorSelf(Context context, String[] events, String[] dates) {
        super(context, R.layout.custom_row_self, events);

        this.events = events;
        this.dates = dates;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater customInflater = LayoutInflater.from(getContext());
        View customView = customInflater.inflate(R.layout.custom_row_self, parent, false);

        TextView eventText = (TextView) customView.findViewById(R.id.eventTitle);
        TextView eventDate = (TextView) customView.findViewById(R.id.eventDate);

        eventText.setText(events[position]);
        eventDate.setText(dates[position]);

        return customView;
    }

}
