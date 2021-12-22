package com.les.futuramaapp.characterFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.les.futuramaapp.DetailActivity;
import com.les.futuramaapp.FuturamaCharacters;
import com.les.futuramaapp.R;


public class RobotsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView characterRecycler =
                (RecyclerView) inflater
                        .inflate(R.layout.fragment_robots, container, false);

        String[] robotNames = new String[FuturamaCharacters.robotCharacters.length];
        for (int i = 0; i < robotNames.length; i++){
            robotNames[i] = FuturamaCharacters.robotCharacters[i].getName();
        }

        int[] robotImages = new int[FuturamaCharacters.robotCharacters.length];
        for (int i = 0; i < robotImages.length; i++){
            robotImages[i] = FuturamaCharacters.robotCharacters[i].getImageResourcesId();
        }

        CharactersAdapter adapter = new CharactersAdapter(robotNames, robotImages);
        characterRecycler.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        characterRecycler.setLayoutManager(gridLayoutManager);

        adapter.setListener(new CharactersAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_CHARTYPE_ID, 1);
                intent.putExtra(DetailActivity.EXTRA_ROBOT_ID, (int) position);
                getActivity().startActivity(intent);
            }
        });

        return characterRecycler;
    }
}