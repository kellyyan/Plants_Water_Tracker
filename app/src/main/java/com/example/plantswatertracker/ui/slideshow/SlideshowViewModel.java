package com.example.plantswatertracker.ui.slideshow;

import android.widget.Switch;
import android.widget.TabHost;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantswatertracker.R;
import com.google.android.material.tabs.TabItem;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("Click on the tabs below to view the amount of water you saved in each scenario!");

    }


    public LiveData<String> getText() {
        return mText;
    }
}