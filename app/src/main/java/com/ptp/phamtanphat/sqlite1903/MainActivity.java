package com.ptp.phamtanphat.sqlite1903;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static SQLite sqLite;
    MonanAdapter monanAdapter;
    ListView listViewMonan;
    ArrayList<Monan> monanArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewMonan = findViewById(R.id.listviewMonan);

        //Tao ra database
        sqLite = new SQLite(MainActivity.this,"Quanan.sql",null,1);
        //Tao ra bang
        String createtable = "CREATE TABLE IF NOT EXISTS Monan(Id INTEGER PRIMARY KEY AUTOINCREMENT , Tenmonan VARCHAR , Giamonan INTEGER)";
        sqLite.QueryData(createtable);
        //Them du lieu va lay tat ca du lieu duoc them vao in ra
        //Ctrl + shift + A : phim tat mo action
//        InserData();
        GetData();
    }

    private void GetData() {
        monanArrayList = new ArrayList<>();
        monanAdapter = new MonanAdapter(this,android.R.layout.simple_list_item_1,monanArrayList);
        listViewMonan.setAdapter(monanAdapter);
        Cursor cursor = sqLite.GetData("SELECT * FROM Monan");
        // Con tro neu co the di chuyen toi dong tiep theo thi se thuc hien vong lap
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String tenmonan = cursor.getString(1);
            int giamonan = cursor.getInt(2);
            monanArrayList.add(new Monan(id,tenmonan,giamonan));
        }
        monanAdapter.notifyDataSetChanged();
    }

//    private void InserData()  {
//        sqLite.QueryData("INSERT INTO Monan VALUES(null,'Com suon',25000)");
//        sqLite.QueryData("INSERT INTO Monan VALUES(null,'Hu tieu',30000)");
//        sqLite.QueryData("INSERT INTO Monan VALUES(null,'Banh xeo',15000)");
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_them,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_them_data :
                Intent intent = new Intent(MainActivity.this,ThemDuLieuActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
