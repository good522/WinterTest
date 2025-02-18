package com.example.wintertest.ui.fragment;

//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.wintertest.R;
//import com.example.wintertest.adapter.AreaAdapter;
//import com.example.wintertest.bean.City;
//import com.example.wintertest.bean.County;
//import com.example.wintertest.bean.Province;
//import com.example.wintertest.helper.AreaDao;
//import com.example.wintertest.helper.AreaViewModel;
//import com.example.wintertest.util.HttpUtil;
//import com.example.wintertest.util.Utility;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import okhttp3.Call;
//import okhttp3.Response;
//
//public class AreaFragment extends Fragment {
//    public AreaViewModel areaViewModel;
//    public abstract AreaDao areaDao();
//    public static final int LEVEL_PROVINCE = 0;
//    public static final int LEVEL_CITY= 1;
//    public static final int LEVEL_COUNTY = 2;
//    private AreaAdapter adapter;
//    private List<String> dataList = new ArrayList<>();
//    private List<Province> provinceList;
//    private List<City> cityList;
//    private List<County> countyList;
//    private Province selectedProvince;
//    private City selectedCity;
//    private int currentLevel;
//    private TextView mtitleText;
//    private Button mbackButton;
//    private RecyclerView mrecyclerView;
//
//    @NonNull
//    @Override
//    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_area, container, false);
//        areaViewModel = new ViewModelProvider(this).get(AreaViewModel.class);
//        mtitleText = (TextView) view.findViewById(R.id.area_title_text);
//        mbackButton = (Button) view.findViewById(R.id.area_back_button);
//        mrecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_area);
//        adapter = new AreaAdapter(provinceList,cityList,countyList);
//        mrecyclerView.setAdapter(adapter);
//        return view;
//    }
//    private void initClick(){
//        mbackButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (currentLevel == LEVEL_COUNTY) {
//                    queryCounties();
//                } else if (currentLevel == LEVEL_CITY) {
//                    querCities();
//                }
//            }
//        });
//        queryProvinces();
//    }
//
//    private void queryProvinces() {
//        mtitleText.setText("中国");
//        mbackButton.setVisibility(View.GONE);
//        areaViewModel.getProvinceName().observe(getViewLifecycleOwner(), new Observer<List<Province>>() {
//            @Override
//            public void onChanged(List<Province> provinces) {
//                if (provinces != null && provinces.size() > 0) {
//                    dataList.clear();
//                    for (Province province : provinces) {
//                        dataList.add(province.getProvinceName());
//                    }
//                }else{
//                    String address = "http://guolin.tech/api/china/";
//                    queryFormServer(address, "province");
//                }
//            }
//        });
//    }
//
//    private void querCities() {
//        mtitleText.setText(selectedProvince.getProvinceName());
//        mbackButton.setVisibility(View.VISIBLE);
//        areaViewModel.getCityName().observe(getViewLifecycleOwner(), new Observer<List<City>>() {
//            @Override
//            public void onChanged(List<City> cities) {
//                if (cities != null && cities.size() > 0) {
//                    dataList.clear();
//                    for (City city : cities) {
//                        dataList.add(city.getCityName());
//                    }
//                }else {
//                    int provinceCode = selectedProvince.getProvinceCode();
//                    String address = "http://guolin.tech/api/china/" + provinceCode;
//                    queryFormServer(address, "city");
//                }
//            }
//        });
//    }
//
//    private void queryCounties() {
//        mtitleText.setText(selectedCity.getCityName());
//        mbackButton.setVisibility(View.VISIBLE);
//        areaViewModel.getCountyName().observe(getViewLifecycleOwner(), new Observer<List<County>>() {
//            @Override
//            public void onChanged(List<County> counties) {
//                if (counties != null && counties.size() > 0) {
//                    dataList.clear();
//                    for (County county : counties) {
//                        dataList.add(county.getCountyName());
//                    }
//                }else {
//                    int provinceCode = selectedProvince.getProvinceCode();
//                    int cityCode = selectedCity.getCityCode();
//                    String address = "http://guolin.tech/api/china/" + provinceCode + "/" + cityCode;
//                    queryFormServer(address, "county");
//                }
//            }
//        });
//    }
//
//    private void queryFormServer(String address, final String type) {
//        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_SHORT).show();
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
//
//                    if (result) {
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if ("province".equals(type)){
//                                    queryProvinces();
//                                } else if ("city".equals(type)){
//                                    querCities();
//                                } else if ("county".equals(type)){
//                                    queryCounties();
//                                }
//                            }
//                        });
//                    }
//               }
//        });
//    }
//}