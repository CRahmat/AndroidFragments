package com.example.recyclerviewandfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = new FHeroesList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragments(selectedFragment);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.fr_home :
                selectedFragment = new User();
                loadFragments(selectedFragment);
                break;
            case R.id.fr_heroes :
                selectedFragment = new FHeroes();
                loadFragments(selectedFragment);
                break;
            case R.id.fr_heroes_list :

                selectedFragment = new FHeroesList();
                loadFragments(selectedFragment);
                break;
        }
        return loadFragments(selectedFragment);
    }

    private boolean loadFragments(Fragment selectedFragment) {
        if(selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fr_frame, selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }


}
