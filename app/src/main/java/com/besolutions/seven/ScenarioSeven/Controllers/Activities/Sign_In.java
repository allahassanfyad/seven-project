package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.besolutions.seven.NetworkLayer.Apicalls;
import com.besolutions.seven.NetworkLayer.NetworkInterface;
import com.besolutions.seven.NetworkLayer.ResponseModel;
import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.User;
import com.besolutions.seven.Utils.TinyDB;
import com.google.gson.Gson;

public class Sign_In extends AppCompatActivity implements NetworkInterface
{

    EditText editTextSignIn,editTextSignup;
    Button btnsignin;
    TextView textsignin;
    User[] userModel;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgin__in);

        tinyDB = new TinyDB(this);

        editTextSignIn = findViewById(R.id.editTextSignIn);
        editTextSignup = findViewById(R.id.editTextSignUp);
        btnsignin = findViewById(R.id.btnSignIn);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextSignIn.getText().toString();
                String pass = editTextSignup.getText().toString();
                new Apicalls(Sign_In.this, Sign_In.this).loginUser(email, pass);
            }
        });

        textsignin = findViewById(R.id.textsignin);
        textsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_In.this, Sign_up.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }


    @Override
    public void OnStart()
    {

    }

    @Override
    public void OnResponse(ResponseModel model)
    {

       if(model.getResponse().equals("False"))
       {
           Toast.makeText(this, "Email or Password is wrong", Toast.LENGTH_SHORT).show();
       }
       else
           {
           Gson gson = new Gson();

           userModel = gson.fromJson(model.getResponse(),User[].class);
               tinyDB.putString("username",userModel[0].getName());
               tinyDB.putString("password",userModel[0].getPassword());
               tinyDB.putString("id",String.valueOf(userModel[0].getId()));
               tinyDB.putString("email",userModel[0].getEmail());
               tinyDB.putString("phone",userModel[0].getPhone());
               tinyDB.putString("country",userModel[0].getCountry());
               tinyDB.putString("city", userModel[0].getCity());
               tinyDB.putString("img",userModel[0].getImageProfile());
               tinyDB.putString("balance",userModel[0].getBalance());


               Intent intent = new Intent(Sign_In.this, MainActivity.class);
               startActivity(intent);

               tinyDB.putBoolean("isLoggedIn",true);


            }





}

    @Override
    public void OnError(VolleyError error)
    {

        Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show();

    }
}
