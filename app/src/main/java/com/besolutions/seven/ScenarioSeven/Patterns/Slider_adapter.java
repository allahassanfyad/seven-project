package com.besolutions.seven.ScenarioSeven.Patterns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.besolutions.seven.R;
import com.bumptech.glide.Glide;

public class Slider_adapter extends PagerAdapter {
    Context context;
    String [] image;


    public Slider_adapter(Context context, String[]image)
    {
        this.context=context;
        this.image=image;
    }

    @Override
    public int getCount()
    {
        return image.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(LinearLayout)o;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.slideimage,container,false);
        ImageView images=(ImageView)view.findViewById(R.id.slidercontain);
        Glide.with(context).load(image[position]).placeholder(R.drawable.imgposting).into(images);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

