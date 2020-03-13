package com.fourthassignment.hdpecalculator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fourthassignment.hdpecalculator.DBHelper.DBHelper;

public class Calculator extends AppCompatActivity {
    private DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        dbHelper = new DBHelper(this);
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            Cursor cursor = dbHelper.selectAll(sqLiteDatabase);
            if (cursor != null && cursor.moveToFirst()) {
                String pressure = cursor.getString(cursor.getColumnIndex("pressure"));
                Toast.makeText(this, bundle.getString("pipe") + pressure, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Ghanta", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
