package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;


import com.besolutions.seven.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation=(BottomNavigationView)findViewById(R.id.navigation);
        fragmentManager=getSupportFragmentManager();
        navigation.setSelectedItemId(R.id.home);
        HomeFragment homeFragment = new HomeFragment();
        loadFragment(homeFragment);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        loadFragment(homeFragment);
                        return true;

                    case R.id.personal:
                        PersonalFragment personalFragment = new PersonalFragment();
                        loadFragment(personalFragment);
                        return true;

                    case R.id.ad:
                        AdFragment adFragment = new AdFragment();
                        loadFragment(adFragment);
                        return true;

                    case R.id.search:
                        SearchFragment searchFragment = new SearchFragment();
                        loadFragment(searchFragment);
                        return true;

                    case R.id.help:
                        HelpFragment helpFragment = new HelpFragment();
                        loadFragment(helpFragment);
                        return true;


                    default:
                        return true;

                }



            }
        });


    }
    private void loadFragment(Fragment fragment)
    {

        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }

}
