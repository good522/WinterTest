package com.example.wintertest.ui.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wintertest.R;
import com.example.wintertest.ui.activity.LoginActivity;

public class PersonageFragment extends Fragment {
    private Button mexitBtn,mchangeBtn;
    private TextView mnameTv;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personage, container, false);
        mexitBtn = view.findViewById(R.id.button_exit);
        mchangeBtn = view.findViewById(R.id.button_change);
        mnameTv = view.findViewById(R.id.userName_textView);
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("user", MODE_PRIVATE);
        String saveuserName = sharedPreferences.getString("userName", "");
        mnameTv.setText(saveuserName);
        initClick();
        return view;
    }
    private void initClick() {
        mexitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        mchangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}