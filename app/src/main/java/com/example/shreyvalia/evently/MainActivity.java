package com.example.shreyvalia.evently;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button butt;
    public static ArrayList<node> references;
    public static String android_id;
//
//    public String android_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Evennntly");
        setSupportActionBar(toolbar);

        references = new ArrayList<>();

        butt = (Button) findViewById(R.id.button);
        butt.setOnClickListener(new MyClass());

//        USERID = null;

//        node n = new node("2");
//        try {
//            n.setStartDate_Time("13-11-1994 2:01:22 AM");
//            n.setEndDate_Time("13-12-1994 1:11:22 PM");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Log.d("The dateTIme", n.getStartDate_Time());
//
//
//        Log.d("The ENDdateTIme", n.getEndDate_Time());


        android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.d("UNIQUE BABY", android_id);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make()
                Toast.makeText(getApplicationContext(), "Replace with your own action", Toast.LENGTH_LONG).show();
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), CreateEventActivity.class);
            startActivity(intent);
        }

    }


}
