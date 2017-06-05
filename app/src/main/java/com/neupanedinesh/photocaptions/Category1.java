package com.neupanedinesh.photocaptions;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neupanedinesh.adapters.RecyclerAdapter;
import com.neupanedinesh.models.CardItemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Category1 extends Fragment {

    private List<CardItemModel> cardItems = new ArrayList<>(20);



    private MainActivity mainActivity;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    public static ArrayList<CardItemModel> data;


    public Category1() {

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cat1_fragment, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.fab_toolbar);

        setupToolbar();



        recyclerView = (RecyclerView)view.findViewById(R.id.fab_recycler_view);

        setupRecyclerView();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {





        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.cat1_fragment_title));
        mainActivity.setSupportActionBar(toolbar);
    }

    private void setupRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
        recyclerView.setHasFixedSize(true);
        initializeCardItemList();
        recyclerAdapter = new RecyclerAdapter(cardItems);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initializeCardItemList(){
        CardItemModel cardItemModel;
        String[] cardTitles = getResources().getStringArray(R.array.cat1_cards);
        String[] cardContents = getResources().getStringArray(R.array.cat1_cards_content);
        final int length = cardTitles.length;
        for(int i=0;i<length;i++){
            cardItemModel = new CardItemModel(cardTitles[i],cardContents[i]);
            cardItems.add(cardItemModel);
        }
    }



}
