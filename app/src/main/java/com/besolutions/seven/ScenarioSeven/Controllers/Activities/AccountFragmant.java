package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.RcyAccount;
import com.besolutions.seven.ScenarioSeven.Patterns.RcyAccountAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AccountFragmant extends Fragment implements RcyAccountAdapter.OnItemListener {

    RadioButton button1;
    RadioButton button2;
    RadioButton button3;

    RelativeLayout relativeLayout;
    RecyclerView recyclerView;


    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.account_fragmant, container, false);

        relativeLayout = (RelativeLayout)view.findViewById(R.id.relativeAccount);
        recyclerView = (RecyclerView)view.findViewById(R.id.rcyAccount);
        button1 = (RadioButton)view.findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                relativeLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

            }
        });
        button2 = (RadioButton)view.findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                relativeLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
        button3 = (RadioButton)view.findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                relativeLayout.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);

            }
        });


        List<RcyAccount> vila = new ArrayList<>();

        int posters[] = {R.drawable.download, R.drawable.download1, R.drawable.download2,
                R.drawable.download3, R.drawable.download4};


        String textPernonal[] = {"فيلا للايجار بسغر مميز", "فيلل في كل انحاْ السعودية", "شقق للايجار ", "فيلا دوبلكس للايجار", "فيلا 3 ادوار للبيع"};

        String textpersonal1[] = {"1/10/2019", "15/10/2019", "22/11/2019", "9/9/2019", "8/12/2019"};

        String textpersonal2[] = {"جدة", "الرياض", "المدينة", "الدمام", "الزهراء"};

        String textpersonal3[] = {"خالد الجهني", "هشام الجخ", "علاء حسن", "محمود صابر", "هشام عبدالله"};

        for (int i = 0; i < posters.length; i++) {

            RcyAccount villa = new RcyAccount(textPernonal[i], textpersonal1[i], textpersonal2[i], textpersonal3[i], posters[i]);

            vila.add(villa);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcyAccount);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RcyAccountAdapter adabter = new RcyAccountAdapter(vila, getContext(), this);
        recyclerView.setAdapter(adabter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onItemClick(int position) {

    }
}
