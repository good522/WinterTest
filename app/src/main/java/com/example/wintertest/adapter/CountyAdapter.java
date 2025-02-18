//package com.example.wintertest.adapter;
//
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
//import com.example.wintertest.bean.County;
//import com.example.wintertest.ui.activity.CountyActivity;
//import com.example.wintertest.ui.activity.WeatherActivity;
//
//import java.util.List;
//
//public class CountyAdapter extends RecyclerView.Adapter<CountyAdapter.CountyViewHolder> {
//    private List<County> counties;
//    private Context context;
//
//    public CountyAdapter(List<County> counties, Context context) {
//        this.counties = counties;
//        this.context = context;
//    }
//
//    @Override
//    public CountyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_county, parent, false);
//        return new CountyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(CountyViewHolder holder, int position) {
//        County county = counties.get(position);
//        holder.textViewCountyName.setText(county.getCountyName());
//        holder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(context, WeatherActivity.class);
//            intent.putExtra("county", (CharSequence) county);
//            context.startActivity(intent);
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return counties.size();
//    }
//
//    static class CountyViewHolder extends RecyclerView.ViewHolder {
//        TextView textViewCountyName;
//
//        CountyViewHolder(View itemView) {
//            super(itemView);
//            textViewCountyName = itemView.findViewById(R.id.recycler_view_city);
//        }
//    }
//}
