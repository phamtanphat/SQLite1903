package com.ptp.phamtanphat.sqlite1903;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by KhoaPhamPC on 9/5/2018.
 */

public class SQLite extends SQLiteOpenHelper {

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Thuc hien cau truy van khong tra ve ket qua (Them xoa sua)
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    //Thuc hien cau truy van tra ve ket qua (Lay du lieu , tra du lieu , moc du lieu trong bang)
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    //Phuong thuc luu dang hinh anh , am thanh
//    public void InsertMedia(){
//        SQLiteDatabase database =  getWritableDatabase();
//        String sql = "INSERT INTO Monan VALUES(null,?,?)";
//        SQLiteStatement sqLiteStatement = database.compileStatement(sql);
//        sqLiteStatement.clearBindings();
//        sqLiteStatement.bindString(1,Ten);
//        //Dang media
//
//        sqLiteStatement.bindBlob(2 , new byte[]{});
//
//
//    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
