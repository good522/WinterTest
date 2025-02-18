//package com.example.wintertest.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.wintertest.R;
//import com.example.wintertest.bean.Province;
//import com.example.wintertest.ui.activity.CityActivity;
//
//import java.util.List;
//
//public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder> {
//
//    private List<Province> provinceList;
//    private Context context;
//
//    public ProvinceAdapter(List<Province> provinceList, Context context) {
//        this.provinceList = provinceList;
//        this.context = context;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_province, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        Province province = provinceList.get(position);
//        holder.provinceName.setText(province.getProvinceName());
//
//        holder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(context, CityActivity.class);
//            intent.putExtra("province", (CharSequence) province);
//            context.startActivity(intent);
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return provinceList.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView provinceName;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            provinceName = itemView.findViewById(R.id.recycler_view_province);
//        }
//    }
//}
