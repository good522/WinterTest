package com.example.wintertest.ui.activity;

//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.lifecycle.Observer;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.wintertest.R;
//import com.example.wintertest.adapter.AreaAdapter;
//import com.example.wintertest.bean.City;
//import com.example.wintertest.bean.Province;
//import com.example.wintertest.helper.AreaViewModel;
//import com.example.wintertest.util.HttpUtil;
//import com.example.wintertest.util.Utility;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.io.IOException;
//import java.util.List;
//
//import okhttp3.Call;
//import okhttp3.Response;
//
//public class CityActivity extends AppCompatActivity {
//    private RecyclerView cityRecyclerView;
//    private TextView mtitleText;
//    private Button mbackButton;
//    private AreaViewModel areaViewModel;
//    private AreaAdapter adapter;
//    private List<String> cityDataList;
//    private Province selectedProvince;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_city);
//        cityRecyclerView = findViewById(R.id.recycler_view_city);
//        mtitleText = findViewById(R.id.city_title_text);
//        mbackButton = findViewById(R.id.city_back_button);
//        initClick();
//        queryCities();
//    }
//
//    private void initClick() {
//        mbackButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CityActivity.this, ProvinceActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void queryCities() {
//        mtitleText.setText(selectedProvince.getProvinceName());
//        areaViewModel.getCityName().observe(this, new Observer<List<City>>() {
//            @Override
//            public void onChanged(List<City> cities) {
//                if (cities != null && cities.size() > 0) {
//                    cityDataList.clear();
//                    for (City city : cities) {
//                        cityDataList.add(city.getCityName());
//                    }
//                } else {
//                    String address = "http://guolin.tech/api/china/" + selectedProvince.getProvinceCode();
//                    queryFormServer(address, "city");
//                }
//            }
//        });
//    }
//    private void queryFormServer(String address, String type) {
//        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(CityActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                String responseText = response.body().string();
//                boolean result = false;
//                if ("province".equals(type)) {
//                    result = Utility.handleProvinceResponse(responseText);
//                } else if ("city".equals(type)) {
//                    result = Utility.handleCityResponse(responseText);
//                } else if ("county".equals(type)) {
//                    result = Utility.handleCountyResponse(responseText);
//                }
//            }
//        });
//    }
//}