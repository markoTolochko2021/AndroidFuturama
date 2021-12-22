package com.les.futuramaapp.signIn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.les.futuramaapp.MainActivity;
import com.les.futuramaapp.R;


public class SignUpFragment extends Fragment{

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    String userName;
    String userLastName;
    String userPassword;


    @Override
    public void onAttach(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("usersFile", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View registerView = inflater.inflate(R.layout.fragment_sign_up, container, false);

        EditText name = (EditText) registerView.findViewById(R.id.edit_text_name);
        EditText lastName = (EditText) registerView.findViewById(R.id.edit_text_last_name);
        EditText password = (EditText) registerView.findViewById(R.id.edit_text_password);
        Button confirmRegister = (Button) registerView.findViewById(R.id.button_confirm_sign_up);

        confirmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = name.getText().toString();
                userLastName = lastName.getText().toString();
                userPassword = password.getText().toString();

                editor.putString("userName", userName);
                editor.putString("userLastName", userLastName);
                editor.putString("userPassword", userPassword);
                editor.apply();

                Toast.makeText(getContext(), "Registered", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), SignInActivity.class);
                startActivity(intent);
            }
        });


        return registerView;
    }
}