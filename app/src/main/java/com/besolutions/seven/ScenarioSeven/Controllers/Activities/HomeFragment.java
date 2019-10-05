package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.besolutions.seven.R;

public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener
{
    private View view;
    Toolbar toolbar;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.home_fragment,container,false);

        Spinner spinner = (Spinner)view.findViewById(R.id.cars);
        Spinner spinner1 = (Spinner)view.findViewById(R.id.allCities);
        Spinner spinner2 = (Spinner)view.findViewById(R.id.saudi);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.cars,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(getContext(),R.array.allCities,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),R.array.saudi,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter2);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
