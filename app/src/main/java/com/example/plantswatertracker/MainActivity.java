package com.example.plantswatertracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;

    public static ArrayList<String> data = new ArrayList<String>();
    public static ArrayList<String> full_data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome to our app! Here you can save water while understanding how much water your plant needs.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private static final String FILE_NAME = "plantList.txt";


    public void addPlant(View v) {
        EditText mEditText = findViewById(R.id.plant_name);
        Spinner spin = findViewById(R.id.type_plant);
        String name = mEditText.getText().toString();
        String text = new String();

        ArrayList<String> saved_data = load();

        for(String s : saved_data){
            String[] split = s.split(" ");
            String added =  "\n" + split[0].replace("_", " ") + "\n\nType: " + split[1].replace("_", " ");
            if(!data.contains(added)) {
                data.add(added);
                full_data.add(s);
            }
        }


        if (spin.getSelectedItem().toString().equals("Annual")){
            text += name.replace(" ", "_") + " " + spin.getSelectedItem().toString() + " " + 5 + "\n";
        } else if (spin.getSelectedItem().toString().equals("Cactus/Succulent")){
            text += name.replace(" ", "_") + " " + spin.getSelectedItem().toString() + " " + 33 + "\n";
        } else if (spin.getSelectedItem().toString().equals("Shrub (desert adapted)")){
            text += name.replace(" ", "_") + " " + spin.getSelectedItem().toString().replace(" ", "_") + " " + 22 + "\n";
        } else if (spin.getSelectedItem().toString().equals("Shrub (desert adapted)")){
            text += name.replace(" ", "_") + " " + spin.getSelectedItem().toString().replace(" ", "_") + " " + 14 + "\n";
        } else {
            text += name.replace(" ", "_") + " " + spin.getSelectedItem().toString().replace(" ", "_") + " " + 3 + "\n";
        }


        data.add("\n" + name + "\n\nType: " + spin.getSelectedItem().toString());
        full_data.add(text);

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(text.getBytes());
            mEditText.getText().clear();
            Toast.makeText(this, "Added " + name,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }

    public void save(View v){
        ArrayList<String> loaded = load();
        ArrayList<String> toWrite = new ArrayList<>();
        for(String item : loaded){
            String[] split = item.split(" ");
            if(data.contains("\n" + split[0] + "\n\nType: " + split[1]) && !toWrite.contains(item)){
                toWrite.add(item);
            }

        }
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            for(String text :toWrite){
                fos.write(text.getBytes());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


    public ArrayList<String> load() {
        FileInputStream fis = null;
        ArrayList<String> arr = new ArrayList<>();
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String text;
            while ((text = br.readLine()) != null) {
                arr.add(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arr;
    }


}


