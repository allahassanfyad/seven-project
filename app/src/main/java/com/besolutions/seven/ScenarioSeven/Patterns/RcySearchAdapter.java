package com.besolutions.seven.ScenarioSeven.Patterns;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class RcySearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<Post> mMainList;
    Context mContext;
    private OnItemListener mOnItemListener;
    TinyDB tinyDB;

    public RcySearchAdapter(List<Post> listpost, Context context, OnItemListener onItemListener) {
        this.mMainList = listpost;
        this.mContext = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        tinyDB = new TinyDB(mContext);

        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_main,parent,false);
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
                .into(mainHolder.poster);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tinyDB.putString("title",main.getTitle());
                tinyDB.putString("date",main.getDatee());
                tinyDB.putString("name",main.getNameMember());
                tinyDB.putString("city",main.getCity());
                tinyDB.putString("description",main.getDes());
                tinyDB.putString("phonenumber",main.getPhone());

                Intent intent = new Intent(mContext,ItemMainFragment.class);
                mContext.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return mMainList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView textmain, textmain1, textmain2,textmain3;
        ImageView poster;
        LinearLayout adsmain;
        OnItemListener onItemListener;
        public MainItemHolder(@NonNull View itemView,OnItemListener onItemListener)
        {
            super(itemView);
            textmain = itemView.findViewById(R.id.textMain);
            textmain1 = itemView.findViewById(R.id.textMain1);
            textmain2 = itemView.findViewById(R.id.textMain2);
            textmain3 = itemView.findViewById(R.id.textMain3);
            poster = itemView.findViewById(R.id.poster);
            adsmain = itemView.findViewById(R.id.adsMain);
            this.onItemListener= onItemListener;



        }


    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
