package com.ptp.phamtanphat.sqlite1903;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThemDuLieuActivity extends AppCompatActivity {

    EditText edtTenmonan , edtGiamonan;
    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_du_lieu);

        btnThem = findViewById(R.id.buttonThem);
        edtGiamonan = findViewById(R.id.edittextGiamonan);
        edtTenmonan = findViewById(R.id.edittextTenmonan);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenmonan = edtTenmonan.getText().toString();
                int giamonan = Integer.parseInt(edtGiamonan.getText().toString());

                if (!tenmonan.equals("") && !String.valueOf(giamonan).equals("")){
                    String insertData = "INSERT INTO Monan VALUES(null,'" + tenmonan + "' , "+ giamonan +")";
                    MainActivity.sqLite.QueryData(insertData);
                    finish();
                }
            }
        });
    }
}
