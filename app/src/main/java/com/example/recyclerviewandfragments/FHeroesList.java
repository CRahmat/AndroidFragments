package com.example.recyclerviewandfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FHeroesList extends Fragment {
    private ArrayList<HeroesModel> listhero = new ArrayList<>();
    public FHeroesList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fheroes_list,container,false);
        listhero.addAll(HeroesData.getHeroList());
        RecyclerView recyclerView = view.findViewById(R.id.rv_heroes_list);
        HeroesAdapter hereosAdapter = new HeroesAdapter(getContext(),HeroesData.getHeroList());
        recyclerView.setAdapter(hereosAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
