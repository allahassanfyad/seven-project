package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.besolutions.seven.NetworkLayer.Apicalls;
import com.besolutions.seven.R;
import com.besolutions.seven.Utils.TinyDB;

public class AdFragment extends Fragment
{
    private View view;

    EditText edittitle,editaddphoto,editphone,editdepartment,editcity,editdes;

    String id_member,title,des, city, category,price,tel,addphoto,sub,x,x2,x3,x4,x5,x6,x7,x8,device;

    Button btnadedit;

    TinyDB tinyDB;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.ad_fragment, container, false);


        edittitle = view.findViewById(R.id.editTextAdTitle);
        editaddphoto = view.findViewById(R.id.editTextAdAddPhoto);
        editphone = view.findViewById(R.id.editTextAdPhone);
        editdepartment = view.findViewById(R.id.editTextAdDepartment);
        editcity = view.findViewById(R.id.editTextAdCity);
        editdes = view.findViewById(R.id.editTextAdDes);
        btnadedit = view.findViewById(R.id.btnAdEdit);
        tinyDB = new TinyDB(getContext());

        id_member = tinyDB.getString("id");

        btnadedit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                title = edittitle.getText().toString();
                addphoto = editaddphoto.getText().toString();


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
