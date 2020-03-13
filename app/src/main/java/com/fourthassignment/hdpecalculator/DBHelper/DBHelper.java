package com.fourthassignment.hdpecalculator.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.fourthassignment.hdpecalculator.Model.RateModel.COLUMN_PRESSURE;
import static com.fourthassignment.hdpecalculator.Model.RateModel.COLUMN_PRICE;
import static com.fourthassignment.hdpecalculator.Model.RateModel.COLUMN_SIZE;
import static com.fourthassignment.hdpecalculator.Model.RateModel.RATE_CREATE;
import static com.fourthassignment.hdpecalculator.Model.RateModel.TABLE_RATE;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "FinalHDPE.db";
    private static final int DB_VERSION = 1;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(RATE_CREATE);
        insertPrice(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_RATE;
        db.execSQL(query);
        onCreate(db);
    }

    public Cursor selectAll(SQLiteDatabase db){
        return db.query(
                TABLE_RATE,
                null,
                null,
null,
                null,
null,
                null
        );
    }

    private void insertPrice(SQLiteDatabase db) {
        String query =
                "INSERT INTO " + TABLE_RATE + "(" + COLUMN_PRESSURE +
                        "," + COLUMN_SIZE + "," + COLUMN_PRICE + ") VALUES" +

                        "('PN 16','20.00 mm - 20.30 mm','0.135'),"+
                        "('PN 16','25.00 mm - 25.30 mm','0.208'),"+
                        "('PN 16','32.00 mm - 32.30 mm','0.338'),"+
                        "('PN 16','40.00 mm - 40.40 mm','0.523'),"+
                        "('PN 16','50.00 mm - 50.50 mm','0.808'),"+
                        "('PN 16','63.00 mm - 63.60 mm','1.270'),"+
                        "('PN 16','75.00 mm - 75.70 mm','1.800'),"+
                        "('PN 16','90.00 mm - 90.90 mm','2.591'),"+
                        "('PN 16','110.00 mm - 111.00 mm','3.840'),"+
                        "('PN 16','125.00 mm - 126.20 mm','4.962'),"+
                        "('PN 16','140.00 mm - 141.30 mm','6.209'),"+
                        "('PN 16','160.00 mm - 161.50 mm','8.134'),"+
                        "('PN 16','180.00 mm - 181.70 mm','10.256'),"+
                        "('PN 16','200.00 mm - 201.80 mm','12.667'),"+
                        "('PN 16','225.00 mm - 227.00 mm','16.014'),"+
                        "('PN 16','250.00 mm - 252.30 mm','19.758'),"+
                        "('PN 16','280.00 mm - 282.60 mm','24.773'),"+
                        "('PN 16','315.00 mm - 317.90 mm','31.307'),"+


                        "('PN 12.5','25.00 mm - 25.30 mm','0.173'),"+
                        "('PN 12.5','32.00 mm - 32.30 mm','0.274'),"+
                        "('PN 12.5','40.00 mm - 40.40 mm','0.434'),"+
                        "('PN 12.5','50.00 mm - 50.50 mm','0.673'),"+
                        "('PN 12.5','63.00 mm - 63.60 mm','1.047'),"+
                        "('PN 12.5','75.00 mm - 75.70 mm','1.481'),"+
                        "('PN 12.5','90.00 mm - 90.90 mm','2.144'),"+
                        "('PN 12.5','110.00 mm - 111.00 mm','3.177'),"+
                        "('PN 12.5','125.00 mm - 126.20 mm','4.089'),"+
                        "('PN 12.5','140.00 mm - 141.30 mm','5.132'),"+
                        "('PN 12.5','160.00 mm - 161.50 mm','6.695'),"+
                        "('PN 12.5','180.00 mm - 181.70 mm','8.466'),"+
                        "('PN 12.5','200.00 mm - 201.80 mm','10.441'),"+
                        "('PN 12.5','225.00 mm - 227.00 mm','13.217'),"+
                        "('PN 12.5','250.00 mm - 252.30 mm','16.263'),"+
                        "('PN 12.5','280.00 mm - 282.60 mm','20.393'),"+
                        "('PN 12.5','315.00 mm - 317.90 mm','25.818'),"+


                        "('PN 10','32.00 mm - 32.30 mm','0.234'),"+
                        "('PN 10','40.00 mm - 40.40 mm','0.360'),"+
                        "('PN 10','50.00 mm - 50.50 mm','0.555'),"+
                        "('PN 10','63.00 mm - 63.60 mm','0.882'),"+
                        "('PN 10','75.00 mm - 75.70 mm','1.248'),"+
                        "('PN 10','90.00 mm - 90.90 mm','1.787'),"+
                        "('PN 10','110.00 mm - 111.00 mm','2.643'),"+
                        "('PN 10','125.00 mm - 126.20 mm','3.405'),"+
                        "('PN 10','140.00 mm - 141.30 mm','4.261'),"+
                        "('PN 10','160.00 mm - 161.50 mm','5.559'),"+
                        "('PN 10','180.00 mm - 181.70 mm','7.054'),"+
                        "('PN 10','200.00 mm - 201.80 mm','8.698'),"+
                        "('PN 10','225.00 mm - 227.00 mm','10.975'),"+
                        "('PN 10','250.00 mm - 252.30 mm','13.520'),"+
                        "('PN 10','280.00 mm - 282.60 mm','16.936'),"+
                        "('PN 10','315.00 mm - 317.90 mm','21.459'),"+


                        "('PN 6','50.00 mm - 50.50 mm','0.365'),"+
                        "('PN 6','63.00 mm - 63.60 mm','0.568'),"+
                        "('PN 6','75.00 mm - 75.70 mm','0.816'),"+
                        "('PN 6','90.00 mm - 90.90 mm','1.148'),"+
                        "('PN 6','110.00 mm - 111.00 mm','1.688'),"+
                        "('PN 6','125.00 mm - 126.20 mm','2.187'),"+
                        "('PN 6','140.00 mm - 141.30 mm','2.750'),"+
                        "('PN 6','160.00 mm - 161.50 mm','3.579'),"+
                        "('PN 6','180.00 mm - 181.70 mm','4.518'),"+
                        "('PN 6','200.00 mm - 201.80 mm','5.564'),"+
                        "('PN 6','225.00 mm - 227.00 mm','7.065'),"+
                        "('PN 6','250.00 mm - 252.30 mm','8.678'),"+
                        "('PN 6','280.00 mm - 282.60 mm','10.885'),"+
                        "('PN 6','315.00 mm - 317.90 mm','13.781');";

        db.execSQL(query);
    }
}
