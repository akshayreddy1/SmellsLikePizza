package com.google.akshay.smellslikepizza.List;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.akshay.smellslikepizza.R;

public class ListFragment extends Fragment {

    public interface onRecipeSelectedInterface{
        void onListRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onRecipeSelectedInterface listener = (onRecipeSelectedInterface) getActivity();

        View view = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        ListAdapter listAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
