package com.example.plantswatertracker.ui.slideshow;

import android.widget.Switch;
import android.widget.TabHost;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantswatertracker.R;
import com.google.android.material.tabs.TabItem;

import static com.example.plantswatertracker.MainActivity.data;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("You saved water for " + data.size() + " plants! \nDetails: ");

    }


    public LiveData<String> getText() {
        return mText;
    }
}