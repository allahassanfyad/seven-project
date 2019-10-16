package com.besolutions.seven.ScenarioSeven.Controllers.Activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.besolutions.seven.NetworkLayer.Apicalls;
import com.besolutions.seven.NetworkLayer.NetworkInterface;
import com.besolutions.seven.NetworkLayer.ResponseModel;
import com.besolutions.seven.R;
import com.besolutions.seven.ScenarioSeven.Models.Post;
import com.besolutions.seven.ScenarioSeven.Patterns.RcySearchAdapter;
import com.besolutions.seven.Utils.MyUtilFile;
import com.besolutions.seven.Utils.TinyDB;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchFragment extends Fragment implements NetworkInterface,RcySearchAdapter.OnItemListener {
    private View view;

    Post[] post;

    TinyDB tinyDB;
    EditText edittextsearch;
    RcySearchAdapter searchasdapter;

    List<Post> searchlist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.search_fragment, container, false);


        edittextsearch =view.findViewById(R.id.editTextSearch);
        tinyDB = new TinyDB(getContext());

        searchasdapter = new RcySearchAdapter(searchlist,getContext(),SearchFragment.this);

        edittextsearch.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    searchlist.clear();
                    String depId = edittextsearch.getText().toString();

                    new Apicalls(getContext(),SearchFragment.this).searchAds(depId);


                    return true;
                }
                return false;
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {


        Gson gson = new Gson();
        post = gson.fromJson(model.getResponse(), Post[].class);

        if (model.getResponse().equals("[]")) {
            Toast.makeText(getContext(), "Sorry There Is Nothing To Show", Toast.LENGTH_SHORT).show();
        }
        else
            {

            for (int i = 0; i < post.length; i++) {

                Post newpost = new Post();

                newpost.setTitle(post[i].getTitle());
                newpost.setDateeC(post[i].getDateeC());
                newpost.setNameMember(post[i].getNameMember());
                newpost.setCity(post[i].getCity());
                newpost.setImage(post[i].getImage());
                newpost.setDatee(post[i].getDatee());
                newpost.setDes(post[i].getDes());
                newpost.setPhone(post[i].getPhone());

                searchlist.add(newpost);

                tinyDB.putString("departmentId", String.valueOf(post[i].getId()));

            }
            RecyclerView recyclerView =view.findViewById(R.id.rcysearch);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            RcySearchAdapter adabter = new RcySearchAdapter(searchlist, getActivity(), this);
            recyclerView.setAdapter(adabter);

        }

    }
    @Override
    public void OnError(VolleyError error) {

        new MyUtilFile(getContext()).showMessage(error.getLocalizedMessage());


    }

    @Override
    public void onItemClick(int position) {

    }
}