package com.aryaan.ankitha.sharedprefwithfragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ankitha on 11/11/2016.
 */
public class AddUserFrag extends Fragment implements View.OnClickListener {

    EditText userName,password;
    Button save;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_user_frag,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userName = (EditText)getActivity().findViewById(R.id.editText);
        password = (EditText)getActivity().findViewById(R.id.editText1);
        save = (Button)getActivity().findViewById(R.id.button);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",userName.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();

        Toast.makeText(getActivity(), "Data saved Successfully", Toast.LENGTH_SHORT).show();
    }
}
