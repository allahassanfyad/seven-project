package com.besolutions.seven.ScenarioSeven.Patterns;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Controllers.Activities.ItemMainFragment;
import com.besolutions.seven.ScenarioSeven.Models.Post;
import com.besolutions.seven.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class RcyAllAdsPersonalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<Post> mMainList;
    Context mContext;
    private OnItemListener mOnItemListener;
    TinyDB tinyDB;

    public RcyAllAdsPersonalAdapter(List<Post> listpost, Context context, OnItemListener onItemListener) {
        this.mMainList = listpost;
        this.mContext = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        tinyDB = new TinyDB(mContext);

        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_ads_personal,parent,false);
        MainItemHolder mainHolder = new MainItemHolder(ads,mOnItemListener) ;


        return mainHolder;
    }

    public class MainHolder extends RecyclerView.ViewHolder{
        public MainHolder(View itemview) {
            super(itemview);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        final Post main  = mMainList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textmain.setText(main.getTitle());
        mainHolder.textmain1.setText(main.getDateeC());
        mainHolder.textmain2.setText(main.getNameMember());
        mainHolder.textmain3.setText(main.getCity());
       // mainHolder.poster.setImageResource(Integer.parseInt(main.getImage()));
        Glide.with(mContext)
                .load(main.getImage())
                .placeholder(R.drawable.imgposting)
                .into(mainHolder.poster);




    }

    @Override
    public int getItemCount() {
        return mMainList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView textmain, textmain1, textmain2,textmain3;
        Button btnedit,btnrefresh,btndelete;
        ImageView poster;
        LinearLayout adsmain;
        OnItemListener onItemListener;
        public MainItemHolder(@NonNull View itemView,OnItemListener onItemListener)
        {
            super(itemView);
            textmain = itemView.findViewById(R.id.textAdPersonalTitle);
            textmain1 = itemView.findViewById(R.id.textAdPersonalDate);
            textmain2 = itemView.findViewById(R.id.textAdPersonalCity);
            textmain3 = itemView.findViewById(R.id.textAdPersonalName);
            poster = itemView.findViewById(R.id.imgAdPersonal);
            adsmain = itemView.findViewById(R.id.adspersonal);
            btndelete = itemView.findViewById(R.id.btnAdPersonalDelete);
            btnedit = itemView.findViewById(R.id.btnAdPersonalEdit);
            btnrefresh = itemView.findViewById(R.id.btnAdPersona1Refresh);
            this.onItemListener= onItemListener;



        }


    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
