package com.example.todo15;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter{
    int nNumofTabs;
    public PageAdapter(@NonNull FragmentManager fm,int behavior){
        super(fm,behavior);
    }
    @NonNull
    @Override
    public Fragment getItem (int postion){
        switch (postion){
            case 0:return new Tabfragment_1();
            case 1:return new TextFragment_2();
            case 2:return new TextFragment_3();
            default:return null;
        }
    }
    @Override
    public int getCount(){
        return nNumofTabs;
    }
}
