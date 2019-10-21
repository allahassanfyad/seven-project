package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.besolutions.seven.NetworkLayer.Apicalls;
import com.besolutions.seven.NetworkLayer.NetworkInterface;
import com.besolutions.seven.NetworkLayer.ResponseModel;
import com.besolutions.seven.R;
import com.besolutions.seven.Utils.MyUtilFile;

public class Sign_up extends AppCompatActivity implements NetworkInterface
{
    EditText edittextname,edittextcity,edittextcountry,edittextemail,edittextpassword,edittextphone;
    Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgin_up);

        edittextname = findViewById(R.id.edittextname);
        edittextcity = findViewById(R.id.editTextcity);
        edittextcountry = findViewById(R.id.editTextcountry);
        edittextemail = findViewById(R.id.editTextemail);
        edittextpassword = findViewById(R.id.editTextpass);
        edittextphone = findViewById(R.id.editTextphone);

        btnsignup = (Button)findViewById(R.id.btnSignup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edittextname.getText().toString();
                String city = edittextcity.getText().toString();
                String country = edittextcountry.getText().toString();
                String mail = edittextemail.getText().toString();
                String password = edittextpassword.getText().toString();
                String phone = edittextphone.getText().toString();


                new Apicalls(Sign_up.this,Sign_up.this).registerUser(name,city,country,mail,password,phone);
            }
        });
    }

    @Override
    public void OnStart()
    {

    }

    @Override
    public void OnResponse(ResponseModel model)
    {
        if (model.getResponse().toString().equals("البريد الالكتروني موجود"))
        {
            new MyUtilFile(this).showMessage("هذا البريد موجود بالفعل ");
        }
        else if (model.getResponse().toString().equals("sent code"))
        {
           new MyUtilFile(this).showMessage("تم تسجيل الدخول بنجاح");

            Intent intent = new Intent(Sign_up.this, MainActivity.class);
            startActivity(intent);

        }

    }

    @Override
    public void OnError(VolleyError error)
    {

    }
}
