package com.example.wintertest.helper;

//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.ViewModel;
//
//import com.example.wintertest.bean.City;
//import com.example.wintertest.bean.County;
//import com.example.wintertest.bean.Province;
//
//import java.util.List;
//
//public class AreaViewModel extends ViewModel {
//    private AreaDao areaDao;
//    private LiveData<String> ProvinceName;
//    private LiveData<String> CityName;
//    private LiveData<String> CountyName;
//    public AreaViewModel(AreaDao areaDao){
//        this.areaDao=areaDao;
//    }
//    public LiveData<List<Province>> getProvinceName(){
//        return new LiveData<List<Province>>() {
//            @Override
//            protected void onActive() {
//                super.onActive();
//                setValue(areaDao.loadAllProvinces());
//            }
//        };
//    }
//    public LiveData<List<City>> getCityName(){
//        return new LiveData<List<City>>() {
//            @Override
//            protected void onActive() {
//                super.onActive();
//                setValue(areaDao.loadAllCities());
//            }
//        };
//    }
//    public LiveData<List<County>> getCountyName(){
//        return new LiveData<List<County>>() {
//            @Override
//            protected void onActive() {
//                super.onActive();
//                setValue(areaDao.loadAllCounties());
//            }
//        };
//    }
//    @Override
//    protected void onCleared() {
//        super.onCleared();
//        ProvinceName=null;
//        CityName=null;
//        CountyName=null;
//    }
//}