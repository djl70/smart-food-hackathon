package com.smartfood.team1.smartfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    pi
    public static final String LOGIN_MESSAGE = "com.smartfood.team1.LOGIN_MESSAGE";
    public static final String LOGIN_EXISTING = "EXISTING";
    public static final String LOGIN_NEW = "NEW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void onButtonPressed(View view) {
        int id = view.getId();

        // Prepare login activity
        Intent intent = new Intent(this, LoginActivity.class);

        // Get message to send to login activity
        String message = "NONE";
        if (id == R.id.button_signin) {
            // Signal existing user
            message = LOGIN_EXISTING;
        } else if (id == R.id.button_signup) {
            // Signal new user
            message = LOGIN_NEW;
        }

        // Start login activity
        intent.putExtra(LOGIN_MESSAGE, message);
        startActivity(intent);
    }
}
