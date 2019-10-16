package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.besolutions.seven.NetworkLayer.Apicalls;
import com.besolutions.seven.NetworkLayer.NetworkInterface;
import com.besolutions.seven.NetworkLayer.ResponseModel;
import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.Post;
import com.besolutions.seven.ScenarioSeven.Models.User;
import com.besolutions.seven.ScenarioSeven.Patterns.RcyAllAdsPersonalAdapter;
import com.besolutions.seven.Utils.TinyDB;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AccountFragmant extends Fragment implements RcyAllAdsPersonalAdapter.OnItemListener, NetworkInterface
{

    RadioButton button1;
    RadioButton button2;
    RadioButton button3;
    TinyDB tinyDB;
    String name1 ,phone1, email1, country1, city1, balance, img1,idmember;

    TextView textaccountname,textbalance;

    EditText accounname,accountphone,accounteamil,accountcity,accountcountry;


    LinearLayout linearLayout;
    RecyclerView recyclerView;

    ImageView imgaccount;

    User[] userModel;

    Post[] post;

    List<Post> alladslist = new ArrayList<>();

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.account_fragmant, container, false);
        tinyDB = new TinyDB(getContext());
        linearLayout = view.findViewById(R.id.relativeAccount);
        recyclerView = view.findViewById(R.id.rcyAccount);
        button1 = view.findViewById(R.id.btnExpire);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alladslist.clear();
                linearLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                idmember = tinyDB.getString("id");
                new Apicalls(getContext(),AccountFragmant.this).epireAds(idmember);

            }
        });
        button2 = view.findViewById(R.id.btnAllAds);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alladslist.clear();
                linearLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                idmember = tinyDB.getString("id");
                new Apicalls(getContext(),AccountFragmant.this).personalAds(idmember);
            }
        });
        button3 = view.findViewById(R.id.btnAccount);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayout.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);

            }
        });



        imgaccount = view.findViewById(R.id.imgAccount);
        textbalance = view.findViewById(R.id.textAmount);
        accounname = view.findViewById(R.id.editTextAccountName);
        accountphone = view.findViewById(R.id.editTextAccountphone);
        accountcity = view.findViewById(R.id.editTextAccountCity);
        accounteamil = view.findViewById(R.id.editTextAccountEmail);
        accountcountry = view.findViewById(R.id.editTextAccountCountry);
        textaccountname = view.findViewById(R.id.textAccountName);


        name1 = tinyDB.getString("username");
        phone1 = tinyDB.getString("phone");
        country1 = tinyDB.getString("country");
        email1 = tinyDB.getString("email");
        city1 = tinyDB.getString("city");
        balance = tinyDB.getString("balance");
        img1 = tinyDB.getString("img");



        Glide.with(this).load(img1).into(imgaccount);

        textbalance.setText(balance);
        accounname.setText("الاسم : "+name1);
        accountphone.setText("الجوال : "+phone1);
        accounteamil.setText("البريد الالكتروني : "+email1);
        accountcity.setText("المدينة : "+city1);
        accountcountry.setText("البلد : "+country1);
        textaccountname.setText(name1);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onItemClick(int position)
    {

    }

    @Override
    public void OnStart()
    {

    }

    @Override
    public void OnResponse(ResponseModel model) {

                Gson json = new Gson();
                post = json.fromJson(model.getResponse(), Post[].class);

                for (int i = 0; i < post.length; i++) {

                    Post newpost = new Post();

                    newpost.setTitle(post[i].getTitle());
                    newpost.setDateeC(post[i].getDateeC());
                    newpost.setNameMember(post[i].getNameMember());
                    newpost.setCity(post[i].getCity());
                    newpost.setImage(post[i].getImage());
                    newpost.setDatee(post[i].getDatee());
                    newpost.setDes(post[i].getDes());
                    newpost.setPhone(post[i].getPhone());

                    alladslist.add(newpost);

                    tinyDB.putString("departmentId", String.valueOf(post[i].getId()));

                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcyAccount);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    RcyAllAdsPersonalAdapter adabter = new RcyAllAdsPersonalAdapter(alladslist, getContext(), this);
                    recyclerView.setAdapter(adabter);



        }
    }

    @Override
    public void OnError(VolleyError error)
    {

        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();


    }
}
