package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import com.besolutions.seven.R;
import com.besolutions.seven.Utils.TinyDB;


import java.util.Timer;
import java.util.TimerTask;

public class Splash_Activity extends AppCompatActivity {
    TinyDB tinyDB;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tinyDB = new TinyDB(this);

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun)
        {
            // Code to run once
            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);

            tinyDB.putBoolean("isLoggedIn",false);

            //editor.commit();
            editor.apply();
        }



        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (!tinyDB.getBoolean("isLoggedIn")) {

                    Intent intent = new Intent(getApplicationContext(), Sign_In.class);
                    startActivity(intent);

                }
                if (tinyDB.getBoolean("isLoggedIn")) {

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }
            }
        };
        new Timer().schedule(timerTask, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (!tinyDB.getBoolean("isLoggedIn")) {

                    Intent intent = new Intent(getApplicationContext(), Sign_In.class);
                    startActivity(intent);

                }
                if (tinyDB.getBoolean("isLoggedIn")) {

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }
            }
        };
        new Timer().schedule(timerTask, 3000);
    }
}
