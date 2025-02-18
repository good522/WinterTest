package com.example.wintertest.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Alert {
    @SerializedName("status")
    public String status;
    @SerializedName("content")
    public Content[] content;
    public class Content {
        @SerializedName("province")
        public String province;
        @SerializedName("city")
        public String city;
        @SerializedName("county")
        public String county;
        @SerializedName("status")
        public String status;
        @SerializedName("title")
        public String title;
        @SerializedName("description")
        public String description;
        //@SerializedName("source")
       // public String source;
        public String getProvince() {
            return province;
        }
        public void setProvince(String province) {
            this.province = province;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public String getCounty() {
            return county;
        }
        public void setCounty(String county) {
            this.county = county;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
    }
    public Content[] getContent() {
        return content;
    }
    public void setContent(Content[] content) {
        this.content = content;
    }
}
