package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.besolutions.seven.R;

public class Sign_In extends AppCompatActivity
{

    Button btnsignin;
    TextView textsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgin__in);

        btnsignin = (Button)findViewById(R.id.btnSignIn);
        btnsignin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Sign_In.this,MainActivity.class);
                startActivity(intent);
            }
        });

        textsignin = (TextView)findViewById(R.id.textsignin);
        textsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_In.this,Sign_up.class);
                startActivity(intent);
            }
        });

    }
}
