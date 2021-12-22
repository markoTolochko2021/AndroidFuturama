package com.les.futuramaagain.logInFragments;

import android.content.Intent;
import android.database.Cursor;
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
import com.les.futuramaagain.TopActivity;
import com.les.futuramaagain.R;


public class LogInFragment extends Fragment {

    private SQLiteDatabase db;
    private String userName;
    private String userPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View logInView = inflater.inflate(R.layout.fragment_log_in, container, false);

        EditText etLogInName = (EditText) logInView.findViewById(R.id.edit_text_log_in_person_name);
        EditText etLogInPassword = (EditText) logInView.findViewById(R.id.edit_text_log_in_password);

        Button btLogIn = (Button) logInView.findViewById(R.id.button_log_in_log_in);
        Button btSignUp = (Button) logInView.findViewById(R.id.button_log_in_sign_up);

        btLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = etLogInName.getText().toString();
                userPassword = etLogInPassword.getText().toString();

                SQLiteOpenHelper futuramaDataBaseHelper = new FuturamaDataBaseHelper(getContext());
                try {
                    db = futuramaDataBaseHelper.getReadableDatabase();
                    Cursor cursor = db.query("USERS",
                            new String[]{"NAME", "PASSWORD"},
                            "NAME = ? AND PASSWORD = ?",
                            new String[]{userName, userPassword},
                            null,null,null);
                    if (cursor.moveToFirst()){
                        Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), TopActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getContext(), "Wrong user name or password", Toast.LENGTH_SHORT).show();
                    }
                    cursor.close();
                    db.close();
                }
                catch (SQLException e){
                    Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Fragment fragment = new SignUpFragment();
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });
        return logInView;
    }
}