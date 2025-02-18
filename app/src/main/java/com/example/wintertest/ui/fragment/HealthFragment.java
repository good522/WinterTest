package com.example.wintertest.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wintertest.R;
import com.example.wintertest.adapter.HealthAdapter;
import com.example.wintertest.gson.Health;
import com.example.wintertest.util.HttpUtil;
import com.example.wintertest.util.Utility;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HealthFragment extends Fragment {
    private List<Health.Suggestion> mlist = new ArrayList<>();
    private EditText mproblemEditText;
    private Button msearchButton;
    private HealthAdapter adapter;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health, container, false);
        mproblemEditText = view.findViewById(R.id.problem_editText);
        msearchButton = view.findViewById(R.id.search_button);
        RecyclerView recyclerView = view.findViewById(R.id.health_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        HealthAdapter adapter = new HealthAdapter(mlist);
        recyclerView.setAdapter(adapter);
        initClick();
        return view;
    }
    private void initClick() {
        msearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestHealth();
            }
        });
    }
    private void requestHealth() {
        String problem =mproblemEditText.getText().toString().trim();
        String healthUrl = "https://whyta.cn/api/tx/healthskill?{API_KEY}&word={problem}";
        String API_KEY = "26c415f649a620501e890e47bf013740";
        String healthUrl1 = healthUrl.replace("{problem}", problem).replace("{API_KEY}", API_KEY);
        HttpUtil.sendOkHttpRequest(healthUrl1, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (getActivity() != null) {
                            Toast.makeText(getActivity(), "获取信息失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseText = response.body().string();
                Utility.responseHealth(responseText);
                Log.d("HealthFragment", "onResponse: " + responseText);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (getActivity() != null) {
                            Gson gson = new Gson();
                            Health health = gson.fromJson(responseText, Health.class);
                            if (health != null && health.suggestionsList != null) {
                                mlist.clear();
                                mlist.addAll(health.suggestionsList);
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        });
    }
}