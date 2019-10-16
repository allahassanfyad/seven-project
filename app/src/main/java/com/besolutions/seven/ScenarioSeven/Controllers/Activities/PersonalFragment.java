package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.besolutions.seven.R;
import com.besolutions.seven.Utils.TinyDB;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PersonalFragment extends Fragment
{
    private View view;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    BottomNavigationView navigationView;

    TinyDB tinyDB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.personal_fragment, container, false);
        fragmentManager=getFragmentManager();
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container5,new AccountFragmant());
        fr.commit();
        tinyDB = new TinyDB(getContext());


        Button button = view.findViewById(R.id.buttonPerAccount);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container5,new AccountFragmant());
                fr.commit();
            }
        });

         Button button1 = view.findViewById(R.id.buttonPerSetting);
         button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container5,new SettingFragment());
                fr.commit();
            }

        });

         Button button2 = view.findViewById(R.id.buttonPerExit);
         button2.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View v)
             {

                 tinyDB.putBoolean("isLoggedIn",false);
                 Intent intent = new Intent(getContext(),Sign_In.class);
                 startActivity(intent);

             }
         });


        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }


}
