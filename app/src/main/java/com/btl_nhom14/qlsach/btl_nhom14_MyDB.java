package com.btl_nhom14.qlsach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.webkit.ConsoleMessage;
import android.widget.Toast;

import java.io.Console;

public class btl_nhom14_MyDB extends SQLiteOpenHelper {
    private Context context;
    SQLiteDatabase sqLiteDatabase;
    public static final String users ="AccountTable";
    public static final String username = "username";
    public static final String password = "password";
    public static final String phone= "phone";
    public static final String id = "id";

    public btl_nhom14_MyDB(Context context) {
        super(context, users, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table AccountTable(username TEXT primary key,password TEXT, phone TEXT, id TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists AccountTable" );
        onCreate(sqLiteDatabase);
    }

    public boolean addAccount(String username, String password, String phone, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("phone",phone);
        values.put("id", id);
        long result = db.insert("AccountTable", null,values);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean KiemTraUser(String username){
        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM AccountTable WHERE username = ? ",new String[]{username});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
    public boolean KiemTraDangNhap(String tendangnhap, String matkhau){
        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM AccountTable WHERE username = ? and password = ? ",new String[]{tendangnhap,matkhau});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
}
