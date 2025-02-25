package com.example.wintertest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wintertest.R;
import com.example.wintertest.bean.Suggestion;
//import com.example.wintertest.gson.Health;

import java.util.ArrayList;
import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ViewHolder> {
//    private Health.Result.Suggestion[] suggestions;
    private List<Suggestion> suggestionList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView healthTitle, healthContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            healthTitle = itemView.findViewById(R.id.rv_title);
            healthContent = itemView.findViewById(R.id.rv_content);
        }
    }
    public HealthAdapter() {
        suggestionList = new ArrayList<>();
    }
//    public void setSuggestion( List<String> suggestionList){
//        if (suggestionList != null) {
//
//        }else {
//            this.suggestionList = new ArrayList<>();
//        }
//            notifyDataSetChanged();
//    }
public void setSuggestion(List<Suggestion> suggestions) {
    if (suggestions != null) {
        this.suggestionList.clear();
        this.suggestionList.addAll(suggestions);
    } else {
        this.suggestionList.clear();
    }
    notifyDataSetChanged();
}
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_health, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Suggestion suggestion = suggestionList.get(position);
        holder.healthTitle.setText(suggestion.getTitle());
        holder.healthContent.setText(suggestion.getContent());
    }
    @Override
    public int getItemCount() {
        return suggestionList.size();
    }
}
