package com.google.akshay.smellslikepizza;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.google.akshay.smellslikepizza.List.ViewPagerFragment;

public abstract class CheckBoxesFragment extends Fragment {
    public   static final String KEY_CHECKED_BOXES = "key_checked_boxes";
    private CheckBox[] mCheckBoxes;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_checkboxes,container,false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.checkBoxesLayout);
        String[] contents = getContents(index);
        mCheckBoxes = new CheckBox[contents.length];
        boolean[] checkedBoxes = new boolean[contents.length];
        if(savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }

        setUpCheckBoxes(contents,linearLayout,checkedBoxes);

        return view;
    }

    public abstract String[] getContents(int index) ;

    private void setUpCheckBoxes(String[] contents, ViewGroup linearLayout, boolean[] checkedBoxes){
        int i =0;
        for (String content : contents) {
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8,16,8,16);
            mCheckBoxes[i].setTextSize(20);
            mCheckBoxes[i].setText(content);
            linearLayout.addView(mCheckBoxes[i]);
            if(checkedBoxes[i]){
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
        int i =0;
        for(CheckBox checkBox : mCheckBoxes){
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKED_BOXES, stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
