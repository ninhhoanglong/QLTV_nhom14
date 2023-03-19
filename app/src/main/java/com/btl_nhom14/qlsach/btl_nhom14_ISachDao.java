package com.btl_nhom14.qlsach;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface btl_nhom14_ISachDao {

    @Insert
    public void insertSach(btl_nhom14_Sach sach);

    @Update
    public void updateSach(btl_nhom14_Sach sach);

    @Delete
    public void deleteSach(btl_nhom14_Sach sach);

    @Query("SELECT * FROM Sach")
    public List<btl_nhom14_Sach> getListSach();

    @Query("SELECT * FROM Sach WHERE maSach = :masach")
    public List<btl_nhom14_Sach> check(String masach);
}
