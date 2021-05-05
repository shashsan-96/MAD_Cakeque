package com.example.cakeque;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DbHandler extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "cake.db";
    public static final String TABLE_NAME = "profile_table";
    public static final String COL_1 = "first_name";
    public static final String COL_2 = "last_name";
    public static final String COL_3 = "user_id";
    public static final String COL_4 = "qualifications";
    public static final String COL_5 = "contact_no";
    public static final String COL_6 = "location";


    public DbHandler( Context context) {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" create table " + TABLE_NAME +" (first_name TEXT,last_name TEXT,user_id TEXT PRIMARY KEY,qualifications TEXT,contact_no TEXT,location TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname,String lname,String id,String qualification,String contact,String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,fname);
        contentValues.put(COL_2,lname);
        contentValues.put(COL_3,id);
        contentValues.put(COL_4,qualification);
        contentValues.put(COL_5,contact);
        contentValues.put(COL_6,location);

        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME,null);
        return res;
    }
}
