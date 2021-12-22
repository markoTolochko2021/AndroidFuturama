package com.les.futuramaagain.characterFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.les.futuramaagain.R;


public class RobotFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView robotRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_robot, container, false);

        return robotRecyclerView;
    }
}