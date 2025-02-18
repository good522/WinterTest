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
//import com.example.wintertest.bean.Province;
//import com.example.wintertest.helper.AreaViewModel;
//import com.example.wintertest.ui.fragment.FirstFragment;
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
//public class ProvinceActivity extends AppCompatActivity {
//    private RecyclerView provinceRecyclerView;
//    private TextView mtitleText;
//    private Button mbackButton;
//    private AreaViewModel areaViewModel;
//    private AreaAdapter adapter;
//    private List<String> provinceDataList;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_province);
//        provinceRecyclerView = findViewById(R.id.recycler_view_province);
//        mtitleText = findViewById(R.id.province_title_text);
//        mbackButton = findViewById(R.id.province_back_button);
//        initClick();
//        queryProvinces();
//    }
//
//    private void initClick() {
//        mbackButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ProvinceActivity.this, FirstFragment.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void queryProvinces() {
//        mtitleText.setText("中国");
//        areaViewModel.getProvinceName().observe(this, new Observer<List<Province>>() {
//            @Override
//            public void onChanged(List<Province> provinces) {
//                if (provinces != null && provinces.size() > 0) {
//                    provinceDataList.clear();
//                    for (Province province : provinces) {
//                        provinceDataList.add(province.getProvinceName());
//                    }
//                }else {
//                    String address = "http://guolin.tech/api/china/";
//                    queryFormServer(address, "province");
//                }
//           }
//      });
//   }
//
//    private void queryFormServer(String address, String type) {
//        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(ProvinceActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
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