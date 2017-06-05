package com.neupanedinesh.photocaptions;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;

import com.neupanedinesh.adapters.CustomGrid;

/**
 * Created by dines on 2017-05-21.
 */
public class MainGrid extends Fragment {
    private MainActivity mainActivity;
    private Toolbar toolbar;
    Activity act;
    GridView grid;
    String[] web = {
            "Attitude",
            "Love",
            "Life",
            "Ex",
            "Smile",
            "Happiness",
            "Sadness",
            "Friendship",
            "Birthday",
            "Family",
            "Funny",
            "Motivation",
            "Pets",
            "Fashion",
            "Thoughts",
            "Simplicity",
            "Holidays",
            "Flirty",







    } ;
    int[] imageId = {
            R.mipmap.ic_attitude,
            R.mipmap.ic_love,
            R.mipmap.ic_life,
            R.mipmap.ic_ex,
            R.mipmap.ic_smile,
            R.mipmap.ic_happiness,
            R.mipmap.ic_sadness,
            R.mipmap.ic_friendship,
            R.mipmap.ic_birthday,
            R.mipmap.ic_family,
            R.mipmap.ic_funny,
            R.mipmap.ic_motivation,
            R.mipmap.ic_pets,
            R.mipmap.ic_fashion,
            R.mipmap.ic_thoughts,
            R.mipmap.ic_simplicity,
            R.mipmap.ic_holidays,
            R.mipmap.ic_flirty,





    };
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_xml, container, false);

        act = getActivity();
        CustomGrid adapter = new CustomGrid(act, web, imageId);

        GridView grid = (GridView) view.findViewById(R.id.grid);
        grid.setAdapter(adapter);

        Animation anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fadi_in);
        grid.setAnimation(anim);
        anim.start();

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                switch (position){
                    case 0:
                        FragmentManager manager = getFragmentManager();
                        manager.beginTransaction().replace(R.id.fragment_container, new Attitude()).addToBackStack(null).commit();


                         break;

                    case 1:

                        FragmentManager manager1 = getFragmentManager();
                        manager1.beginTransaction().replace(R.id.fragment_container, new Category1()).addToBackStack(null).commit();

                        break;


                }



            }
        });




        toolbar = (Toolbar)view.findViewById(R.id.fab_toolbar);

        setupToolbar();











        return view;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }


    private void setupToolbar(){
        toolbar.setTitle("Categories");
        mainActivity.setSupportActionBar(toolbar);
    }





}
