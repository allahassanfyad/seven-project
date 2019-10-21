package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.besolutions.seven.NetworkLayer.Apicalls;
import com.besolutions.seven.NetworkLayer.NetworkInterface;
import com.besolutions.seven.NetworkLayer.ResponseModel;
import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.Post;
import com.besolutions.seven.ScenarioSeven.Patterns.RcyMainAdapter;
import com.besolutions.seven.Utils.MyUtilFile;
import com.besolutions.seven.Utils.TinyDB;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener, RcyMainAdapter.OnItemListener, NetworkInterface
{
    private View view;
    Toolbar toolbar;
    LinearLayout adsmain;
    Post[] post;
    TinyDB tinyDB;

    String img,img1,img2,img3,img4,img5,img6,img7;

    String[] ads;

    String departments;
    String cities;


    List<Post> postList = new ArrayList<>();

    ImageView poster;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.home_fragment,container,false);

        postList.clear();
        final Spinner spinner1 = view.findViewById(R.id.cars);
        final Spinner spinner2 = view.findViewById(R.id.allCities);
        Spinner spinner3 = view.findViewById(R.id.saudi);
        Spinner spinner = new Spinner(getContext());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.department,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                postList.clear();
                departments = spinner1.getSelectedItem().toString();
                new Apicalls(getContext(),HomeFragment.this).selectByDepartment(departments);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(getContext(),R.array.allCities,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                postList.clear();
                cities = spinner2.getSelectedItem().toString();
                if (spinner2.getSelectedItem().toString().equals("كل المدن"))
                {
                    new Apicalls(getContext(),HomeFragment.this).mainAds();
                }
                else
                    {
                        new Apicalls(getContext(), HomeFragment.this).select_By_City(cities);
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),R.array.saudi,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter2);


        tinyDB = new TinyDB(getContext());

        new Apicalls(getContext(),HomeFragment.this).mainAds();

        img = tinyDB.getString("img");
        img1 = tinyDB.getString("img1");
        img2 = tinyDB.getString("img2");
        img3 = tinyDB.getString("img3");
        img4 = tinyDB.getString("img4");
        img5 = tinyDB.getString("img5");
        img6 = tinyDB.getString("img6");
        img7 = tinyDB.getString("img7");



        ads = new String[8];

        ads[0]=(img);
        ads[1]=(img1);
        ads[2]=(img2);
        ads[3]=(img3);
        ads[4]=(img4);
        ads[5]=(img5);
        ads[6]=(img6);
        ads[7]=(img7);



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


    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {

            Gson gson = new Gson();
            post = gson.fromJson(model.getResponse(),Post[].class);


            for ( int i =0; i<post.length; i++)
            {

                Post newpost = new Post();

                newpost.setTitle(post[i].getTitle());
                newpost.setDateeC(post[i].getDateeC());
                newpost.setNameMember(post[i].getNameMember());
                newpost.setCity(post[i].getCity());
                newpost.setImage(post[i].getImage());
                newpost.setDatee(post[i].getDatee());
                newpost.setDes(post[i].getDes());
                newpost.setPhone(post[i].getPhone());
                newpost.setImage(post[i].getImage());
                newpost.setImage2(post[i].getImage2());
                newpost.setImage3(post[i].getImage3());
                newpost.setImage4(post[i].getImage4());
                newpost.setImage5(post[i].getImage5());
                newpost.setImage6(post[i].getImage6());
                newpost.setImage7(post[i].getImage7());
                newpost.setImage8(post[i].getImage8());
                newpost.setPhone(post[i].getPhone());
                newpost.setURL(post[i].getURL());


                postList.add(newpost);
                tinyDB.putString("IdMember",post[i].getIdMember());
                tinyDB.putString("urlItem",post[i].getURL());
                tinyDB.putString("ad phone",post[i].getPhone());
                tinyDB.putString("department",post[i].getDepartment());

                tinyDB.putString("img",post[i].getImage());
                tinyDB.putString("img1",post[i].getImage2());
                tinyDB.putString("img2",post[i].getImage3());
                tinyDB.putString("img3",post[i].getImage4());
                tinyDB.putString("img4",post[i].getImage5());
                tinyDB.putString("img5",post[i].getImage6());
                tinyDB.putString("img6",post[i].getImage7());
                tinyDB.putString("img7",post[i].getImage8());


            }

        //recyclerview setup

        RecyclerView recyclerView = view.findViewById(R.id.rcyclMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RcyMainAdapter adabter = new RcyMainAdapter(postList,getActivity(),this);
        recyclerView.setAdapter(adabter);

    }

    @Override
    public void OnError(VolleyError error) {

        new MyUtilFile(getContext()).showMessage(error.toString());
    }

    public void Img_Factory (String adsww)
    {
            if(adsww == null)
            {
                adsww = String.valueOf((Glide.with(this).load("http://alosboiya.com.sa/images/imgposting.png").placeholder(R.drawable.imgposting).into(poster)));


            }
           else if (adsww.contains("~"))
            {
                adsww.replace("~","");
                String remain = "http://www.alosboiya.com.sa" + adsww;
                Glide.with(getContext()).load(remain).placeholder(R.drawable.imgposting).into(poster);
            }




    }

}
