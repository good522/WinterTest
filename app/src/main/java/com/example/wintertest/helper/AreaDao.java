package com.example.wintertest.helper;

//import androidx.lifecycle.LiveData;
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import com.example.wintertest.bean.City;
//import com.example.wintertest.bean.County;
//import com.example.wintertest.bean.Province;
//
//import java.util.List;
//
//@Dao
//public interface AreaDao {
//    @Insert
//    void insertProvince(Province province);
//    @Insert
//    void insertProvinces(List<Province> provinceList);
//    @Insert
//    void insertCity(City city);
//    @Insert
//    void insertCities(List<City> cityList);
//    @Insert
//    void insertCounty(County county);
//    @Insert
//    void insertCounties(List<County> countyList);
//    @Query("SELECT * FROM province")
//    List<Province> loadAllProvinces();
//    @Query("SELECT * FROM city")
//    List <City> loadAllCities();
//    @Query("SELECT * FROM county")
//    List<County> loadAllCounties();
//    @Query("SELECT EXISTS(SELECT 1 FROM province WHERE provinceName = :provinceName)")
//    long checkIfProvinceExists(String provinceName);
//    @Query("SELECT EXISTS(SELECT 1 FROM city WHERE cityName = :cityName)")
//    long checkIfCityExists(String cityName);
//    @Query("SELECT EXISTS(SELECT 1 FROM county WHERE countyName = :countyName)")
//    long checkIfCountyExists(String countyName);
//    @Query("SELECT * FROM province WHERE provinceName = :provinceName")
//    LiveData<List<String>> getProvinceName(String provinceName);
//    @Query("SELECT * FROM city WHERE cityName = :cityName")
//    LiveData<List<String>> getCityName(String cityName);
//    @Query("SELECT * FROM county WHERE countyName = :countyName")
//    LiveData<List<String>> getCountyName(String countyName);
//    @Update
//    void updateProvince(Province province);
//    @Update
//    void updateProvinces(List<Province> provinceList);
//    @Update
//    void updateCity(City city);
//    @Update
//    void updateCities(List<City> cityList);
//    @Update
//    void updateCounty(County county);
//    @Update
//    void updateCounties(List<County> countyList);
//    @Delete
//    void deleteProvince(Province province);
//    @Delete
//    void deleteProvinces(List<Province> provinceList);
//    @Delete
//    void deleteCity(City city);
//    @Delete
//    void deleteCities(List<City> cityList);
//    @Delete
//    void deleteCounty(County county);
//    @Delete
//    void deleteCounties(List<County> countyList);
//}
