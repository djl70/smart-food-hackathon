package com.smartfood.team1.smartfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateVolunteerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_volunteer);
    }

    public void onButtonPressed(View view) {
        int id = view.getId();

        if (id == R.id.button_back) {
            // Close this activity and return to the previous one
            finish();
        } else if (id == R.id.button_next) {
            // Open the next activity, which will prompt for driving information / wanted duties
        }
    }
}
