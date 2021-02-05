package com.vivekojha.multiplelayoutrv.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vivekojha.multiplelayoutrv.FragmentRecyclerviewAdapter;
import com.vivekojha.multiplelayoutrv.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Fragment1 extends Fragment {

    RecyclerView FragmentRecyclerview;
    ArrayList<String> fgTextArrayList = new ArrayList<>();

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        FragmentRecyclerview = view.findViewById(R.id.fragmentRecyclerView);

        /*LinearLayoutManager layoutManagerForFragment = new LinearLayoutManager(getActivity());
        layoutManagerForFragment.setOrientation(RecyclerView.HORIZONTAL);
        layoutManagerForFragment.setReverseLayout(false);*/

        LinearLayoutManager layoutManagerForFragment = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        FragmentRecyclerview.setLayoutManager(layoutManagerForFragment);


        fgTextArrayList.clear();
        String[] text = {"one", "Two", "Three", "Four", "Five", "Six", "Seven"};
        fgTextArrayList.addAll(Arrays.asList(text));

        FragmentRecyclerviewAdapter fgAdapter = new FragmentRecyclerviewAdapter(fgTextArrayList);
        FragmentRecyclerview.setAdapter(fgAdapter);
        FragmentRecyclerview.setHasFixedSize(true);
        fgAdapter.notifyDataSetChanged();

        return view;
    }
}