package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;


import com.besolutions.seven.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Toolbar toolbar;
    TextView textback;
    ImageView imgplus;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        fragmentManager=getSupportFragmentManager();
        navigation.setSelectedItemId(R.id.home);
        HomeFragment homeFragment = new HomeFragment();
        loadFragment(homeFragment);
        toolbar = findViewById(R.id.toolbar);
        textback = toolbar.findViewById(R.id.textBack);
        imgplus = toolbar.findViewById(R.id.imgPlus);
        imgplus.setVisibility(View.VISIBLE);
        textback.setVisibility(View.INVISIBLE);

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
                            imgplus.setVisibility(View.VISIBLE);
                            textback.setVisibility(View.INVISIBLE);
                            return true;


                            case R.id.personal:
                                PersonalFragment personalFragment = new PersonalFragment();
                                loadFragment(personalFragment);
                                imgplus.setVisibility(View.VISIBLE);
                                textback.setVisibility(View.VISIBLE);
                                return true;

                            case R.id.ad:
                                AdFragment adFragment = new AdFragment();
                                loadFragment(adFragment);
                                imgplus.setVisibility(View.INVISIBLE);
                                textback.setVisibility(View.INVISIBLE);
                                return true;

                            case R.id.search:
                                SearchFragment searchFragment = new SearchFragment();
                                loadFragment(searchFragment);
                                imgplus.setVisibility(View.INVISIBLE);
                                textback.setVisibility(View.INVISIBLE);
                                return true;

                            case R.id.help:
                                HelpFragment helpFragment = new HelpFragment();
                                loadFragment(helpFragment);
                                imgplus.setVisibility(View.INVISIBLE);
                                textback.setVisibility(View.INVISIBLE);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }


}
