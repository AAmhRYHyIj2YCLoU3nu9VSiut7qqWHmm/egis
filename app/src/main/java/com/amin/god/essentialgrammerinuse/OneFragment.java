package com.amin.god.essentialgrammerinuse;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.lang.reflect.Field;


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
        int unit_number = getArguments().getInt("unit_number");
        assert strtext != null;
        switch (strtext) {
            case "A":
                String format = String.format("unit%d_a", unit_number);
//        int resId = getResId(format, Layout.class);
                int resID = container.getContext().getResources().getIdentifier(format, "layout", getContext().getPackageName());
                return inflater.inflate(resID, container, false);
            case "B":
                resID = container.getContext().getResources().getIdentifier(String.format("unit%d_b", unit_number), "layout", getContext().getPackageName());
                return inflater.inflate(resID, container, false);
            case "C":
                resID = container.getContext().getResources().getIdentifier(String.format("unit%d_c", unit_number), "layout", getContext().getPackageName());
                return inflater.inflate(resID, container, false);
        }

        return inflater.inflate(R.layout.fragment_one, container, false);

    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int returnResoure(int unit_number) {
        switch (unit_number) {
            case 1:
                return R.layout.unit1_a;
            case 2:
                return R.layout.unit1_a;
            case 3:
                return R.layout.unit1_a;
            case 4:
                return R.layout.unit1_a;
            case 5:
                return R.layout.unit1_a;
            case 6:
                return R.layout.unit1_a;
            case 7:
                return R.layout.unit1_a;
            case 8:
                return R.layout.unit1_a;


        }
        return -1;
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