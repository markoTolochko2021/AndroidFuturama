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


public class HumansFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView characterRecycler =
                (RecyclerView) inflater
                        .inflate(R.layout.fragment_humans, container, false);

        String[] humanNames = new String[FuturamaCharacters.humanCharacters.length];
        for (int i = 0; i < humanNames.length; i++){
            humanNames[i] = FuturamaCharacters.humanCharacters[i].getName();
        }

        int[] humanImages = new int[FuturamaCharacters.humanCharacters.length];
        for (int i = 0; i < humanImages.length; i++){
            humanImages[i] = FuturamaCharacters.humanCharacters[i].getImageResourcesId();
        }

        CharactersAdapter adapter = new CharactersAdapter(humanNames, humanImages);
        characterRecycler.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        characterRecycler.setLayoutManager(gridLayoutManager);

        adapter.setListener(new CharactersAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_CHARTYPE_ID, 3);
                intent.putExtra(DetailActivity.EXTRA_HUMAN_ID, (int) position);
                getActivity().startActivity(intent);
            }
        });
        return characterRecycler;
    }
}