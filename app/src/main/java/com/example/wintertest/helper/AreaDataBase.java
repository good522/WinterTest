package com.example.wintertest.helper;

import android.content.Context;

//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.example.wintertest.bean.City;
//import com.example.wintertest.bean.County;
//import com.example.wintertest.bean.Province;
//
//@Database(entities = {Province.class, City.class, County.class},version = 1,exportSchema = false)
//public class AreaDataBase extends RoomDatabase {
//    public abstract AreaDao areaDao();
//    public static volatile AreaDataBase mInstance;
//    public static AreaDataBase getInstance(Context context){
//        if (mInstance == null){
//            synchronized (AreaDataBase.class){
//                if (mInstance == null){
//                    mInstance = Room.databaseBuilder(context.getApplicationContext(),AreaDataBase.class,"area_database").build();
//                }
//            }
//        }
//        return mInstance;
//    }
//}
