package com.btl_nhom14.qlsach;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {btl_nhom14_Sach.class}, version = 1)
public abstract class btl_nhom14_DatabaseApp extends RoomDatabase {
    public abstract btl_nhom14_ISachDao getSachDao();
    private static btl_nhom14_DatabaseApp instance;
    public static synchronized btl_nhom14_DatabaseApp getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), btl_nhom14_DatabaseApp.class,"quanlithuvien")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public static void destroyInstance() {
        instance = null;
    }
}
