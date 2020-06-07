package com.example.plantswatertracker.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.plantswatertracker.First;
import com.example.plantswatertracker.Fourth;
import com.example.plantswatertracker.Second;
import com.example.plantswatertracker.Third;

public class PagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior, int tabsNumber) {
        super(fm, behavior);
        this.tabsNumber = tabsNumber;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new First();
            case 1:
                return new Second();
            case 2:
                return new Third();
            case 3:
                return new Fourth();
            default:
                return null    ;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
