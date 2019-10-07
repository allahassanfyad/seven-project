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
import com.besolutions.seven.ScenarioSeven.Models.RcyMain;

import java.util.List;

public class RcyMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<RcyMain> mMainList;
    Context mContext;
    private OnItemListener mOnItemListener;

    public RcyMainAdapter(List<RcyMain> songsList, Context context,OnItemListener onItemListener) {
        this.mMainList = songsList;
        this.mContext = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
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
        final RcyMain main  = mMainList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textmain.setText(main.getTextMain());
        mainHolder.textmain1.setText(main.getTextMain1());
        mainHolder.textmain2.setText(main.getTextMain2());
        mainHolder.poster.setImageResource(main.getPoster());


    }

    @Override
    public int getItemCount() {
        return mMainList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textmain, textmain1, textmain2,textmain3;
        ImageView poster;
        LinearLayout adsmain;
        OnItemListener onItemListener;
        public MainItemHolder(@NonNull View itemView,OnItemListener onItemListener)
        {
            super(itemView);
            textmain = (TextView) itemView.findViewById(R.id.textMain);
            textmain1 = (TextView) itemView.findViewById(R.id.textMain1);
            textmain2 = (TextView) itemView.findViewById(R.id.textMain2);
            textmain3 = (TextView) itemView.findViewById(R.id.textMain3);
            poster = (ImageView)  itemView.findViewById(R.id.poster);
            adsmain = (LinearLayout) itemView.findViewById(R.id.adsMain);
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
                    Intent intent = new Intent(mContext, ItemMainFragment.class);
                    mContext.startActivity(intent);
                }
            });

        }
    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
