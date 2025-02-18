package com.example.wintertest.adapter;

//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.recyclerview.widget.RecyclerView;
//import android.widget.TextView;
//
//import com.example.wintertest.R;
//import com.example.wintertest.bean.City;
//import com.example.wintertest.ui.activity.CountyActivity;
//
//import java.util.List;
//
//public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{
//    private List<City> cityList;
//    private Context context;
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_city, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        City city = cityList.get(position);
//        holder.cityName.setText(city.getCityName());
//        holder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(context, CountyActivity.class);
//            intent.putExtra("city", (CharSequence) city);
//            context.startActivity(intent);
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return cityList.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView cityName;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            cityName = itemView.findViewById(R.id.recycler_view_city);
//        }
//    }
//}
