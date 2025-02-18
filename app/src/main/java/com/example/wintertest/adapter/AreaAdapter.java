package com.example.wintertest.adapter;

//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.wintertest.R;
//import com.example.wintertest.bean.City;
//import com.example.wintertest.bean.County;
//import com.example.wintertest.bean.Province;
//import com.example.wintertest.ui.activity.CityActivity;
//
//import java.util.List;
//
//public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {
//    private List<Province> mProvinceList;
//    private List<City> mCityList;
//    private List<County> mCountyList;
//    private Context mprovinceContext, mcityContext, mcountyContext;
//    static class ViewHolder extends RecyclerView.ViewHolder{
//        View mAreaView;
//        TextView mProvinceName, mCityName, mCountyName;
//        public ViewHolder(@NonNull View view)
//        {
//            super(view);
//            mAreaView = view;
//            mProvinceName = (TextView) view.findViewById(R.id.province_name);
//            mCityName = (TextView) view.findViewById(R.id.city_name);
//            mCountyName = (TextView) view.findViewById(R.id.county_name);
//        }
//    }
//    public AreaAdapter(List<Province> provinceList, List<City> cityList, List<County> countyList, Context provinceContext, Context cityContext, Context countyContext){
//        mProvinceList = provinceList;
//        mCityList = cityList;
//        mCountyList = countyList;
//        mprovinceContext = provinceContext;
//        mcityContext = cityContext;
//        mcountyContext = countyContext;
//    }
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_area, parent, false);
//        return new ViewHolder(view);
//    }
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder provinceHolder, int position) {
//        Province province = mProvinceList.get(position);
//        provinceHolder.mProvinceName.setText(province.getProvinceName());
//        provinceHolder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(mprovinceContext, CityActivity.class);
//            intent.putExtra("province", province);
//            mprovinceContext.startActivity(intent);
//        });
//    }
//    }
//}
