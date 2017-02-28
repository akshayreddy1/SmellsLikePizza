package com.google.akshay.smellslikepizza.Grid;

import com.google.akshay.smellslikepizza.R;
import com.google.akshay.smellslikepizza.RecyclerAdapter;

public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.onRecipeSelectedInterface mListner;

    public GridAdapter(GridFragment.onRecipeSelectedInterface listener) {
        mListner = listener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListner.onGridRecipeSelected(index);
    }
}
