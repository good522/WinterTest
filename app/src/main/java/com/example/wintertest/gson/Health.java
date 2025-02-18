package com.example.wintertest.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Health {
    @SerializedName("list")
    public List<Suggestion> suggestionsList;
    public class Suggestion {
        @SerializedName("title")
        public String title;
        @SerializedName("content")
        public String content;
        public  String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }
    }
}
