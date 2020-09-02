package com.example.databaseapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button bsave, bview, bupdate, bdelete;
    OnDbOpListner dbOpListner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public interface OnDbOpListner {
        public void DbOpPerfomed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        bsave = v.findViewById(R.id.button_del);
        bview = v.findViewById(R.id.button2);
        bupdate = v.findViewById(R.id.button3);
        bdelete = v.findViewById(R.id.button4);

        bsave.setOnClickListener(this);
        bview.setOnClickListener(this);
        bupdate.setOnClickListener(this);
        bdelete.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_del:
                dbOpListner.DbOpPerfomed(0);
                break;

            case R.id.button2:
                dbOpListner.DbOpPerfomed(1);
                break;
            case R.id.button3:
                dbOpListner.DbOpPerfomed(2);
                break;

            case R.id.button4:
                dbOpListner.DbOpPerfomed(3);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {

            dbOpListner = (OnDbOpListner) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "exception here");
        }
    }
}