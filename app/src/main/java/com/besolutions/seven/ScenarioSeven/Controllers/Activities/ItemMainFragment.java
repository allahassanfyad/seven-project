package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.VolleyError;
import com.besolutions.seven.NetworkLayer.Apicalls;
import com.besolutions.seven.NetworkLayer.NetworkInterface;
import com.besolutions.seven.NetworkLayer.ResponseModel;
import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.Post;
import com.besolutions.seven.ScenarioSeven.Patterns.RcyMainGridAdapter;
import com.besolutions.seven.ScenarioSeven.Patterns.Slider_adapter;
import com.besolutions.seven.Utils.MyUtilFile;
import com.besolutions.seven.Utils.TinyDB;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ItemMainFragment extends AppCompatActivity implements RcyMainGridAdapter.OnItemListener, NetworkInterface
{
    private View view;
    private ViewPager viewPager;
    Post[] post;
    TextView textitemtitle,textitemdate,textitemname,textitemcity,textitemdesc;
    Button btnnumber;

    String title,date,name,city,description,phonenumber;

    String img,img1,img2,img3,img4,img5,img6,img7,department,URLItem;

    String[] ads;

    Slider_adapter slider_adapter;

    ImageView slidercontain;

    TinyDB tinyDB;

    ImageView imgtwitter,imgface,imgplus;

    List<Post> suggestlist = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_main_fragment);

        slidercontain = findViewById(R.id.slidercontain);


        textitemtitle = findViewById(R.id.textItemTitle);
        textitemdate = findViewById(R.id.textItemDate);
        textitemname = findViewById(R.id.textItemName);
        textitemcity = findViewById(R.id.textItemCity);
        textitemdesc = findViewById(R.id.textItemDes);
        btnnumber = findViewById(R.id.btnItemNumber);
        imgtwitter = findViewById(R.id.imgTwitter);
        imgface = findViewById(R.id.imgFace);
        imgplus = findViewById(R.id.imgPlus);
        tinyDB = new TinyDB(this);

        btnnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tinyDB.getString("ad phone")));
                startActivity(intent);

            }
        });
        imgtwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                URLItem = tinyDB.getString("urlItem");
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,"http://alosboiya.com.sa"+URLItem );
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });
        imgface.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                URLItem = tinyDB.getString("urlItem");
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,"http://alosboiya.com.sa"+URLItem );
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        imgplus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                URLItem = tinyDB.getString("urlItem");
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,"http://alosboiya.com.sa"+URLItem );
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });







        title = tinyDB.getString("title");
        date = tinyDB.getString("date");
        name = tinyDB.getString("name");
        city = tinyDB.getString("city");
        description = tinyDB.getString("description");
        phonenumber = tinyDB.getString("ad phone");

        textitemtitle.setText(title);
        textitemdate.setText(date);
        textitemname.setText(name);
        textitemcity.setText(city);
        textitemdesc.setText(description);
        btnnumber.setText(phonenumber);

        img = tinyDB.getString("img");
        img1 = tinyDB.getString("img1");
        img2 = tinyDB.getString("img2");
        img3 = tinyDB.getString("img3");
        img4 = tinyDB.getString("img4");
        img5 = tinyDB.getString("img5");
        img6 = tinyDB.getString("img6");
        img7 = tinyDB.getString("img7");
        slider();
        department = tinyDB.getString("department");
        new Apicalls(this,this).suggestAds(department);

    }


    private void slider()
    {
       String[] ads={img,img1,img2,img3,img4,img5,img6,img7};
       for (int i = 0; i<ads.length; i++)

               if(ads[i]==null) {

                   ads[i] = String.valueOf((Glide.with(this).load("http://alosboiya.com.sa/images/imgposting.png").placeholder(R.drawable.imgposting).into(slidercontain)));


               }
               //Glide.with(this).load("http://alosboiya.com.sa/images/imgposting.png").placeholder(R.drawable.imgposting).into(slidercontain);


               viewPager = findViewById(R.id.slider);
               slider_adapter = new Slider_adapter(this, ads);
               viewPager.setAdapter(slider_adapter);

    }
    @Override
    public void onStop(){
        super.onStop();
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
    public void OnResponse(ResponseModel model)
    {

        Gson gson = new Gson();
        post = gson.fromJson(model.getResponse(), Post[].class);

        for (int i = 0; i < post.length; i++) {

            Post newpost = new Post();

            newpost.setTitle(post[i].getTitle());
            newpost.setCity(post[i].getCity());
            newpost.setImage(post[i].getImage());

            suggestlist.add(newpost);

            tinyDB.putString("departmentId", String.valueOf(post[i].getId()));

        }
        RecyclerView recyclerView = findViewById(R.id.rcyclgrid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        RcyMainGridAdapter adabter = new RcyMainGridAdapter(suggestlist,this,this);
        recyclerView.setAdapter(adabter);
    }

    @Override
    public void OnError(VolleyError error)
    {

        new MyUtilFile(this).showMessage(error.getLocalizedMessage());


    }
}
