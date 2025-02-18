package com.example.wintertest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wintertest.R;
import com.example.wintertest.gson.Health;

import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ViewHolder> {
    private List<Health.Suggestion> suggestionList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView healthTitle, healthContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            healthTitle = itemView.findViewById(R.id.rv_title);
            healthContent = itemView.findViewById(R.id.rv_content);
        }
    }
    public HealthAdapter(List<Health.Suggestion> suggestionlist) {
           this.suggestionList = suggestionlist;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_health, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Health.Suggestion suggestion = suggestionList.get(position);
        holder.healthTitle.setText(suggestion.getTitle());
        holder.healthContent.setText(suggestion.getContent());
    }
    @Override
    public int getItemCount() {
        return suggestionList.size();
    }
}
