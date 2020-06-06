package com.example.plantswatertracker.ui.home;


import android.os.Bundle;
import android.view.View;

import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.plantswatertracker.R;


import java.util.ArrayList;
import java.util.List;

import static com.example.plantswatertracker.MainActivity.data;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private final String FILE_NAME = "plantList.txt";

    ListView listView;
    EditText textValue;
    Button addButton;
    Spinner spin;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        textValue = (EditText) root.findViewById(R.id.plant_name);
        addButton = (Button) root.findViewById(R.id.add_button);
        listView = (ListView) root.findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);




        return root;
    }








}