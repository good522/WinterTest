package com.example.wintertest.ui.activity;

//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.wintertest.R;
//import com.example.wintertest.adapter.AreaAdapter;
//import com.example.wintertest.bean.City;
//import com.example.wintertest.bean.County;
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
//public class CountyActivity extends AppCompatActivity {
//    private RecyclerView countyRecyclerView;
//    private TextView mtitleText;
//    private Button mbackButton;
//    private AreaViewModel areaViewModel;
//    private AreaAdapter adapter;
//    private List<String> countyDataList;
//    private City selectedCity;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_county);
//        countyRecyclerView = findViewById(R.id.recycler_view_county);
//        mtitleText = findViewById(R.id.county_title_text);
//        mbackButton =findViewById(R.id.county_back_button);
//        initClick();
//        queryCounties();
//    }
//
//    private void initClick() {
//        mbackButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CountyActivity.this, CityActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void queryCounties() {
//        mtitleText.setText(selectedCity.getCityName());
//        areaViewModel.getCountyName().observe(this, new Observer<List<County>>() {
//            @Override
//            public void onChanged(List<County> counties) {
//                if (counties != null && counties.size() > 0) {
//                    countyDataList.clear();
//                    for (County county : counties) {
//                        countyDataList.add(county.getCountyName());
//                    }
//                }else {
//                    String address = "http://guolin.tech/api/china/" + selectedCity.getProvinceId() + "/" + selectedCity.getCityCode();
//                    queryFormServer(address, "county");
//                }
//            }
//        });
//    }
//
//    private void queryFormServer(String address, String type) {
//        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(CountyActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
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