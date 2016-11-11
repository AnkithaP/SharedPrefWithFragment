package com.aryaan.ankitha.sharedprefwithfragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ankitha on 11/11/2016.
 */
public class DisplayUserFrag extends Fragment implements View.OnClickListener {

    TextView userText,passText;
    Button load;
    private static final String DEFAULT = "N/A";

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.display_user_frag,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userText = (TextView)getActivity().findViewById(R.id.textView3);
        passText = (TextView)getActivity().findViewById(R.id.textView5);
        load = (Button)getActivity().findViewById(R.id.button2);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username",DEFAULT);
        String pass = sharedPreferences.getString("password",DEFAULT);

        if (name.equals(DEFAULT) || pass.equals(DEFAULT)){
            Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
        }else {
            userText.setText(name);
            passText.setText(pass);
            Toast.makeText(getActivity(), "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
