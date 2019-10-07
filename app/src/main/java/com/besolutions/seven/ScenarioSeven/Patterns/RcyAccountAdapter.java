package com.besolutions.seven.ScenarioSeven.Patterns;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Controllers.Activities.ItemMainFragment;
import com.besolutions.seven.ScenarioSeven.Models.RcyAccount;
import com.besolutions.seven.ScenarioSeven.Models.RcyMain;

import java.util.List;

public class RcyAccountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<RcyAccount> mMainList;
    Context mContext;
    private OnItemListener mOnItemListener;

    public RcyAccountAdapter(List<RcyAccount> songsList, Context context, OnItemListener onItemListener) {
        this.mMainList = songsList;
        this.mContext = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
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
        final RcyAccount main  = mMainList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textadpersona1.setText(main.getTextadpersonal());
        mainHolder.textadpersona2.setText(main.getTextadpersonal1());
        mainHolder.textadpersona3.setText(main.getTextadpersonal2());
        mainHolder.textadpersona4.setText(main.getTextadpersonal3());
        mainHolder.poster.setImageResource(main.getPoster());


    }

    @Override
    public int getItemCount() {
        return mMainList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textadpersona1, textadpersona2, textadpersona3,textadpersona4;
        ImageView poster;
        RelativeLayout adsmain;
        OnItemListener onItemListener;
        public MainItemHolder(@NonNull View itemView,OnItemListener onItemListener)
        {
            super(itemView);
            textadpersona1 = (TextView) itemView.findViewById(R.id.textAdPersona);
            textadpersona2 = (TextView) itemView.findViewById(R.id.textAdPersonal);
            textadpersona3 = (TextView) itemView.findViewById(R.id.textAdPersona2);
            textadpersona4 = (TextView) itemView.findViewById(R.id.textAdPersona3);
            poster = (ImageView)  itemView.findViewById(R.id.imgAdPersonal);
            adsmain = (RelativeLayout) itemView.findViewById(R.id.relativeAccount);
            this.onItemListener= onItemListener;

             itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            onItemListener.onItemClick(getAdapterPosition());

            adsmain.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                }
            });

        }
    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
