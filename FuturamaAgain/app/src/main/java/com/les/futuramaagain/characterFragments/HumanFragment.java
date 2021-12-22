package com.les.futuramaagain.characterFragments;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.les.futuramaagain.R;
import com.les.futuramaagain.futuramaDataBase.FuturamaDataBaseHelper;

import java.util.ArrayList;


public class HumanFragment extends Fragment {
    private SQLiteDatabase db;
    private Cursor cursor;
    private ArrayList<String> names;
    private ArrayList<Integer> imagesIds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView humanRecyclerView =
                (RecyclerView) inflater.
                        inflate(R.layout.fragment_human,
                                container,
                                false);

        SQLiteOpenHelper helper = new FuturamaDataBaseHelper(getContext());
        try {
            db = helper.getReadableDatabase();
            cursor = db.query("HUMANS",
                    new String[]{"_id","NAME", "IMAGE_RESOURCES_ID"},
                    null, null, null, null, null);

            if (cursor.moveToFirst()){
                names = new ArrayList<>();
                imagesIds = new ArrayList<>();
                do {
                    names.add(cursor.getString(1));
                    imagesIds.add(cursor.getInt(2));
                }
                while (cursor.moveToNext());
            }

                FuturamaCharactersAdapter adapter = new FuturamaCharactersAdapter(names, imagesIds);
                humanRecyclerView.setAdapter(adapter);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
                humanRecyclerView.setLayoutManager(gridLayoutManager);
        }
        catch (SQLException e){
            Toast.makeText(getContext(), "Something wrong!!!", Toast.LENGTH_SHORT).show();
        }

        return humanRecyclerView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cursor.close();
        db.close();
    }
}