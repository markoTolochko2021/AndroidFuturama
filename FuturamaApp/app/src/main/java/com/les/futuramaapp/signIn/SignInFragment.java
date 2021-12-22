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


public class SignInFragment extends Fragment{

    private ChangeFragment changeFragment;
    private String userName;
    private String userPassword;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public void setChangeFragment(ChangeFragment changeFragment) {
        this.changeFragment = changeFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("usersFile", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View signInView = inflater.inflate(R.layout.fragment_sign_in, container, false);

        EditText userNameEd = (EditText) signInView.findViewById(R.id.edit_text_user_name);
        EditText userPasswordEd = (EditText) signInView.findViewById(R.id.edit_text_user_password);
        Button logInButton = (Button) signInView.findViewById(R.id.button_log_in);
        Button registerButton = (Button) signInView.findViewById(R.id.button_register);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = userNameEd.getText().toString();
                userPassword = userPasswordEd.getText().toString();

                String name = sharedPreferences.getString("userName", null);
                String password = sharedPreferences.getString("userPassword", null);

                if (userName.equals(name) && userPassword.equals(password)){
                    Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getContext(), "Wrong user name or password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeFragment != null){
                    changeFragment.changeFragment();
                }
            }
        });


        return signInView;
    }
}