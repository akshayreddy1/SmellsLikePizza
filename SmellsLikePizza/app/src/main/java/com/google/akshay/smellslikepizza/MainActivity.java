package com.google.akshay.smellslikepizza;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.akshay.smellslikepizza.Grid.DualPaneFragment;
import com.google.akshay.smellslikepizza.Grid.GridFragment;
import com.google.akshay.smellslikepizza.List.ListFragment;
import com.google.akshay.smellslikepizza.List.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.onRecipeSelectedInterface, GridFragment.onRecipeSelectedInterface {
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet = getResources().getBoolean(R.bool.isTablet);
        if(!isTablet){
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if(savedFragment ==null){
                ListFragment listFragment = new ListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.placeHolder,listFragment,LIST_FRAGMENT);
                    fragmentTransaction.commit();
            }
        }else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if(savedFragment ==null){
                GridFragment gridFragment = new GridFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.placeHolder,gridFragment,LIST_FRAGMENT);
                    fragmentTransaction.commit();
            }
        }


    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX,index);
            fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.placeHolder,fragment,VIEWPAGER_FRAGMENT);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualPaneFragment fragment = new DualPaneFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX,index);
            fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.placeHolder,fragment,VIEWPAGER_FRAGMENT);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
    }
}
