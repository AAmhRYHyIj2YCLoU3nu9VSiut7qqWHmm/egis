package com.amin.god.essentialgrammerinuse;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


public class OneFragment extends Fragment {

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        assert getArguments() != null;
        String strtext = getArguments().getString("segment");
        assert strtext != null;
        switch (strtext) {
            case "A":
                return inflater.inflate(R.layout.unit1_a, container, false);
            case "B":
                return inflater.inflate(R.layout.unit1_b, container, false);
            case "C":
                return inflater.inflate(R.layout.unit1_c, container, false);
        }

        return inflater.inflate(R.layout.fragment_one, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CheckBox checkBox = view.findViewById(R.id.checkBox0);
        if (checkBox != null) {
            View.OnClickListener onClickListener = v -> {
            };
            checkBox.setOnClickListener(onClickListener);
        }


    }
}