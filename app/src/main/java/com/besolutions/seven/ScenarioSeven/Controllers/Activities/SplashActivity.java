package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Controllers.Activities.Sign_In;
import com.besolutions.seven.Utils.TinyDB;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    TinyDB tinyDB;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tinyDB = new TinyDB(this);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run()
            {
                if(!tinyDB.getBoolean("isLoggedIn"))
                {
                    Intent intent = new Intent(SplashActivity.this,Sign_In.class);
                    startActivity(intent);

                }if (tinyDB.getBoolean("isLoggedIn"))
                {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            }
        };
        new Timer().schedule(timerTask,3000);
    }
}
