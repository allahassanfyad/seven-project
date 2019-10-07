package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.RcyMain;
import com.besolutions.seven.ScenarioSeven.Patterns.RcyMainAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener, RcyMainAdapter.OnItemListener
{
    private View view;
    Toolbar toolbar;
    LinearLayout adsmain;
    Context context;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.home_fragment,container,false);

        Spinner spinner =  new Spinner(getContext());
        Spinner spinner1 = (Spinner)view.findViewById(R.id.cars);
        Spinner spinner2 = (Spinner)view.findViewById(R.id.allCities);
        Spinner spinner3 = (Spinner)view.findViewById(R.id.saudi);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.cars,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(getContext(),R.array.allCities,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),R.array.saudi,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter2);




        List<RcyMain> vila = new ArrayList<>();

        int posters[] ={R.drawable.download, R.drawable.download1, R.drawable.download2,
                R.drawable.download3, R.drawable.download4};


        String textMain[] ={"فيلا للايجار بسغر مميز", "فيلل في كل انحاْ السعودية", "شقق للايجار ", "فيلا دوبلكس للايجار", "فيلا 3 ادوار للبيع"};

        String textMain1[] ={"1/10/2019", "15/10/2019", "22/11/2019","9/9/2019", "8/12/2019"};

        String textMain2[] ={"جدة", "الرياض", "المدينة","الدمام", "الزهراء"};

        String textMain3[] = {"خالد الجهني", "هشام الجخ", "علاء حسن", "محمود صابر", "هشام عبدالله" };

        for (int i =0; i < posters.length; i++){

            RcyMain villa = new RcyMain(textMain[i],textMain1[i],textMain2[i],textMain3[i],posters[i] );

            vila.add(villa);
        }
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rcyclMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RcyMainAdapter adabter = new RcyMainAdapter(vila,getContext(),this);
        recyclerView.setAdapter(adabter);



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

    @Override
    public void onItemClick(int position) {
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container,new ItemMainFragment());
        fr.commit();

    }
}
