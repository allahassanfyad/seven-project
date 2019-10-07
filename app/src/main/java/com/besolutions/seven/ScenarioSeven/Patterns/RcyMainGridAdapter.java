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
import com.besolutions.seven.ScenarioSeven.Models.RcyMainGrid;

import java.util.List;

public class RcyMainGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<RcyMainGrid> mMainGridList;
    Context mContext;
    private OnItemListener mOnItemListener;

    public RcyMainGridAdapter(List<RcyMainGrid> songsList, Context context, OnItemListener onItemListener) {
        this.mMainGridList = songsList;
        this.mContext = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggestions,parent,false);
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
        final RcyMainGrid main  = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textsuggest.setText(main.getTextsuggest());
        mainHolder.textsuggest1.setText(main.getTextsuggest1());
        mainHolder.poster.setImageResource(main.getPoster1());


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textsuggest,textsuggest1;
        ImageView poster;
        LinearLayout lineasuggest;
        OnItemListener onItemListener;
        public MainItemHolder(@NonNull View itemView,OnItemListener onItemListener)
        {
            super(itemView);
            textsuggest = (TextView) itemView.findViewById(R.id.textSuggest);
            textsuggest1 = (TextView) itemView.findViewById(R.id.textSuggest1);
            poster = (ImageView)  itemView.findViewById(R.id.poster1);
            lineasuggest = (LinearLayout) itemView.findViewById(R.id.linearSuggestion);
            this.onItemListener= onItemListener;

             itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            onItemListener.onItemClick(getAdapterPosition());

            lineasuggest.setOnClickListener(new View.OnClickListener()
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
