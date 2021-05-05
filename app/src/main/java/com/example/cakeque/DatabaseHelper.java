package com.example.cakeque;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "cake.db";
    public static final String TABLE_NAME = "proposal_table";

    public static final String COL_1 = "USERID";
    public static final String COL_2 = "ORDERID";
    public static final String COL_3 = "PROPOSITION";
    public static final String COL_4 = "CAKECOST";
    public static final String COL_5 = "DELIVERCOST";
    public static final String COL_6 = "TOTALCOST";
    public static final String COL_7 = "CONTACTS";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (USERID TEXT,ORDERID TEXT PRIMARY KEY,PROPOSITION TEXT,CAKECOST TEXT,DELIVERCOST TEXT,TOTALCOST TEXT,CONTACTS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String userid,String orderid,String proposition,String cakecost,String delivercost,String totalcost,String contacts) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,userid);
        contentValues.put(COL_2,orderid);
        contentValues.put(COL_3,proposition);
        contentValues.put(COL_4,cakecost);
        contentValues.put(COL_5,delivercost);
        contentValues.put(COL_6,totalcost);
        contentValues.put(COL_7,contacts);

        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


}
