package com.example.shreyvalia.evently;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    Button butt;

    String USERID;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Evennntly");
        setSupportActionBar(toolbar);

        butt = (Button) findViewById(R.id.button);
        butt.setOnClickListener(new MyClass());

        USERID = null;

        Firebase.setAndroidContext(this);
        //firebase ref
         Firebase myFirebaseRef = new Firebase("https://eventlyforthehack.firebaseio.com/");
//        myFirebaseRef.authAnonymously(myFirebaseRef.authResultHandler("anonymous"));

//            mAuthProgressDialog.show();
//        myFirebaseRef.authAnonymously(new Firebase.AuthResultHandler() {
//            @Override
//            public void onAuthenticated(AuthData authData) {
//
//            }
//
//            @Override
//            public void onAuthenticationError(FirebaseError firebaseError) {
//
//            }
//        });
//

//        myFirebaseRef.authAnonymously(new Firebase.AuthResultHandler() {
//            @Override
//            public void onAuthenticated(AuthData authData) {
//                // we've authenticated this session with your Firebase app
//               USERID = authData.getUid();
//                Log.d(" frifjiw", "hfhuf8rf");
//            }
//            @Override
//            public void onAuthenticationError(FirebaseError firebaseError) {
//                // there was an error
//            }
//        });
//
//        Log.d("MAIN ACTIVITY USER", " " + USERID);


// myFirebaseRef.getAuth()
//        myFirebaseRef.authAnonymously();


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
            Intent intent = new Intent(getApplicationContext(), slider.class);
            startActivity(intent);
        }

    }

}
