package com.example.plantswatertracker.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.plantswatertracker.R;
import com.example.plantswatertracker.ui.home.HomeViewModel;
import com.example.plantswatertracker.ui.home.MyCustomAdapter;

import static com.example.plantswatertracker.MainActivity.data;
import static com.example.plantswatertracker.MainActivity.full_data;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        listView = (ListView) root.findViewById(R.id.listView2);
        MyCustomAdapter2 adapter = new MyCustomAdapter2(full_data, getContext());

        listView.setAdapter(adapter);

        return root;
    }





}