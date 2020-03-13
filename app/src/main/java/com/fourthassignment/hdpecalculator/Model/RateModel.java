package com.fourthassignment.hdpecalculator.Model;

public class RateModel {
    public static final String TABLE_RATE = "rate";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_PRESSURE = "pressure";
    public static final String COLUMN_PRICE = "price";

    public static final String RATE_CREATE = "CREATE TABLE " + TABLE_RATE +
            " ("+COLUMN_PRESSURE + " TEXT," +
            COLUMN_SIZE + " TEXT," +
            COLUMN_PRICE + " TEXT);";

    private String size, pressure, price;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
