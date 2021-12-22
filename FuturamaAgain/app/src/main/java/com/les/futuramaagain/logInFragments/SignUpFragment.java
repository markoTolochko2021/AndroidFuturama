package com.les.futuramaagain.logInFragments;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.les.futuramaagain.futuramaDataBase.FuturamaDataBaseHelper;
import com.les.futuramaagain.R;


public class SignUpFragment extends Fragment {

    private SQLiteDatabase db;
    private String userName;
    private String userPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View signUpView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        EditText etName = (EditText) signUpView.findViewById(R.id.edit_text_sign_up_person_name);
        EditText etPassword = (EditText) signUpView.findViewById(R.id.edit_text_sing_up_password);
        Button btOk = (Button) signUpView.findViewById(R.id.button_sing_up_ok);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = etName.getText().toString();
                userPassword = etPassword.getText().toString();

                SQLiteOpenHelper futuramaDataBaseHelper = new FuturamaDataBaseHelper(getContext());
                try {
                    db = futuramaDataBaseHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("NAME", userName);
                    contentValues.put("PASSWORD", userPassword);
                    db.insert("USERS", null, contentValues);
                    Toast.makeText(getContext(), "Registered", Toast.LENGTH_SHORT).show();

                    Fragment fragment = new LogInFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
                catch (SQLException e){
                    Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });
        return signUpView;
    }
}