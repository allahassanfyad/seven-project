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
import com.besolutions.seven.ScenarioSeven.Models.RcyMainGrid;
import com.bumptech.glide.Glide;

import java.util.List;

public class RcyMainGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<Post> mMainGridList;
    Context mContext;
    private OnItemListener mOnItemListener;

    public RcyMainGridAdapter(List<Post> songsList, Context context, OnItemListener onItemListener) {
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
        final Post main  = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textsuggesttitle.setText(main.getTitle());
        mainHolder.textsuggestcity.setText(main.getCity());
        Glide.with(mContext)
                .load(main.getImage())
                .placeholder(R.drawable.imgposting)
                .into(mainHolder.postersuggest);


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textsuggesttitle,textsuggestcity;
        ImageView postersuggest;
        LinearLayout lineasuggest;
        OnItemListener onItemListener;

        public MainItemHolder(@NonNull View itemView,OnItemListener onItemListener)
        {
            super(itemView);
            textsuggesttitle = itemView.findViewById(R.id.textSuggestTitle);
            textsuggestcity = itemView.findViewById(R.id.textSuggestCity);
            postersuggest = itemView.findViewById(R.id.posterSuggest);
            lineasuggest = itemView.findViewById(R.id.linearSuggestion);
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
