package com.smartfood.team1.smartfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AccountTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);
    }

    public void onButtonPressed(View view) {
        int id = view.getId();

        if (id == R.id.button_volunteer) {
            // Volunteer
            startActivity(new Intent(this, CreateVolunteerActivity.class));
            return;
        } else if (id == R.id.button_bank) {
            // Food bank
        } else if (id == R.id.button_industry) {
            // Food industry
        }
    }
}
