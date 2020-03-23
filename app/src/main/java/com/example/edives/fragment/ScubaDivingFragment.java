package com.example.edives.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edives.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScubaDivingFragment extends Fragment {


    public ScubaDivingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scuba_diving, container, false);
    }

}
