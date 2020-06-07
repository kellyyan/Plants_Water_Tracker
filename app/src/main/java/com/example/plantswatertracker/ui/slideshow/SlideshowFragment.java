package com.example.plantswatertracker.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.plantswatertracker.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class SlideshowFragment extends Fragment {
    TabItem tab1;
    TabItem tab2;
    TabItem tab3;
    TextView info;

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View r = inflater.inflate(R.layout.fragment_slideshow, container, false);
        tab1 = r.findViewById(R.id.tab1);
        tab2 = r.findViewById(R.id.tab2);
        tab3 = r.findViewById(R.id.tab3);
        info = r.findViewById(R.id.infoOnWaterSaved);
        TabLayout tabLayout = (TabLayout) r.findViewById(R.id.tabs); // get the reference of TabLayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // called when tab selected
                info.setText("The water is wa   iew;josfkd" );

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // called when tab unselected
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // called when a tab is reselected
                info.setText("The water is" );
            }
        });

        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public void setInfo(){

    }
}

