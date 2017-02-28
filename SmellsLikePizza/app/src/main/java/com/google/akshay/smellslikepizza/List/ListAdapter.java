package com.google.akshay.smellslikepizza.List;

import com.google.akshay.smellslikepizza.R;
import com.google.akshay.smellslikepizza.RecyclerAdapter;

public class ListAdapter extends RecyclerAdapter {
    private final ListFragment.onRecipeSelectedInterface mListner;

    public ListAdapter(ListFragment.onRecipeSelectedInterface listener) {
        mListner = listener;
    }


    @Override
    public int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListner.onListRecipeSelected(index);
    }
}
