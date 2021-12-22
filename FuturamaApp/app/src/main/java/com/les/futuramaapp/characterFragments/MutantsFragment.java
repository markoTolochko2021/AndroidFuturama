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


public class MutantsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView characterRecycler = (RecyclerView) inflater
                .inflate(R.layout.fragment_mutants, container, false);

        String[] mutantNames = new String[FuturamaCharacters.mutantCharacters.length];
        for (int i = 0; i < mutantNames.length; i++){
            mutantNames[i] = FuturamaCharacters.mutantCharacters[i].getName();
        }

        int[] mutantsImages = new int[FuturamaCharacters.mutantCharacters.length];
        for (int i = 0; i < mutantsImages.length; i++){
            mutantsImages[i] = FuturamaCharacters.mutantCharacters[i].getImageResourcesId();
        }

        CharactersAdapter adapter = new CharactersAdapter(mutantNames, mutantsImages);
        characterRecycler.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        characterRecycler.setLayoutManager(gridLayoutManager);

        adapter.setListener(new CharactersAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_CHARTYPE_ID, 2);
                intent.putExtra(DetailActivity.EXTRA_MUTANT_ID, (int) position);
                getActivity().startActivity(intent);
            }
        });

        return characterRecycler;
    }
}