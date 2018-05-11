package com.ptp.phamtanphat.sqlite1903;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tao ra database
        sqLite = new SQLite(MainActivity.this,"Quanan.sql",null,1);
        //Tao ra bang
        String createtable = "CREATE TABLE IF NOT EXISTS Monan(Id INTEGER PRIMARY KEY AUTOINCREMENT , Tenmonan VARCHAR , Giamonan INTEGER)";
        sqLite.QueryData(createtable);
        //Them du lieu va lay tat ca du lieu duoc them vao in ra
        //Ctrl + shift + A : phim tat mo action
        InserData();
    }

    private void InserData() {
        sqLite.QueryData("INSERT INTO Monan (null,'Com suon',25000)");
        sqLite.QueryData("INSERT INTO Monan (null,'Hu tieu',30000)");
        sqLite.QueryData("INSERT INTO Monan (null,'Banh xeo',15000)");
    }
}
