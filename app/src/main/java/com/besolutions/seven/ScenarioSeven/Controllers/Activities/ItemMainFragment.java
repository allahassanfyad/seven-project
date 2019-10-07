package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.RcyMain;
import com.besolutions.seven.ScenarioSeven.Models.RcyMainGrid;
import com.besolutions.seven.ScenarioSeven.Patterns.RcyMainAdapter;
import com.besolutions.seven.ScenarioSeven.Patterns.RcyMainGridAdapter;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemMainFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener,RcyMainGridAdapter.OnItemListener
{
    private View view;
    private SliderLayout msliderlayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.item_main_fragment, container, false);

        msliderlayout=(SliderLayout)view.findViewById(R.id.slider);


        HashMap<String,Integer> photos=new HashMap<String, Integer>();
        photos.put("photo Ads",R.drawable.download);
        photos.put("photo Ads 2",R.drawable.download1);
        photos.put("photo Ads 3",R.drawable.download2);
        photos.put("photo Ads 4",R.drawable.download3);
        photos.put("photo Ads 5",R.drawable.download4);
        photos.put("photo Ads 6",R.drawable.vila);

        for (String name : photos.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());

            textSliderView
                    .description(name)
                    .image(photos.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            msliderlayout.addSlider(textSliderView);

        }


            List<RcyMainGrid> vila = new ArrayList<>();

            int posters[] ={R.drawable.download, R.drawable.download1, R.drawable.download2,
                    R.drawable.download3, R.drawable.download4};


            String textsuggest[] ={"فيلا للايجار بسغر مميز", "فيلل في كل انحاْ السعودية", "شقق للايجار ", "فيلا دوبلكس للايجار", "فيلا 3 ادوار للبيع"};

            String textsuggest1[] = {"خالد الجهني", "هشام الجخ", "علاء حسن", "محمود صابر", "هشام عبدالله" };

            for (int i =0; i < posters.length; i++)
            {

                RcyMainGrid villa = new RcyMainGrid(textsuggest[i],textsuggest1[i],posters[i]);

                vila.add(villa);
            }

            RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rcyclgrid);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            RcyMainGridAdapter adabter = new RcyMainGridAdapter(vila,getContext(),this);
            recyclerView.setAdapter(adabter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStop(){
        msliderlayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getContext(),slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {
        Log.d("MainActivity", "Page Changed: " + position);


    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }

    @Override
    public void onItemClick(int position)
    {
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container,new ItemMainFragment());
        fr.commit();
    }
}
