package com.example.cakeque;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "cake_database";
    //Database Table name
    private static final String TABLE_NAME = "PROFILE";
    //Table columns
    public static final String ID = "id";
    public static final String FNAME = "fname";
    public static final String LNAME = "lname";
    public static final String UID = "userid";
    public static final String QUALIFICATIONS = "qualifications";
    public static final String CONTACT = "contact";
    public static final String LOCATION = "location";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + FNAME + " TEXT NOT NULL,"+LNAME+" TEXT NOT NULL,"+UID+" TEXT NOT NULL,"+QUALIFICATIONS+" TEXT NOT NULL,"+CONTACT+" TEXT NOT NULL,"+LOCATION+" TEXT NOT NULL);";
    //Constructor
    public DatabaseHelperClass (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Profile Data
    public void addProfile(ProfileModelClass profileModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.FNAME, profileModelClass.getFname());
        contentValues.put(DatabaseHelperClass.LNAME, profileModelClass.getLname());
        contentValues.put(DatabaseHelperClass.UID, profileModelClass.getUserid());
        contentValues.put(DatabaseHelperClass.QUALIFICATIONS, profileModelClass.getQualifications());
        contentValues.put(DatabaseHelperClass.CONTACT, profileModelClass.getContact());
        contentValues.put(DatabaseHelperClass.LOCATION, profileModelClass.getLocation());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
    }

    public List<ProfileModelClass> getProfileList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<ProfileModelClass> storeProfile = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String fname = cursor.getString(1);
                String lname = cursor.getString(2);
                String userid = cursor.getString(3);
                String qualifications = cursor.getString(4);
                String contact = cursor.getString(5);
                String location = cursor.getString(6);
                storeProfile.add(new ProfileModelClass(id,fname,lname,userid,qualifications,contact,location));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeProfile;
    }

    public void updateProfile(ProfileModelClass profileModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.FNAME, profileModelClass.getFname());
        contentValues.put(DatabaseHelperClass.LNAME, profileModelClass.getLname());
        contentValues.put(DatabaseHelperClass.UID, profileModelClass.getUserid());
        contentValues.put(DatabaseHelperClass.QUALIFICATIONS, profileModelClass.getQualifications());
        contentValues.put(DatabaseHelperClass.CONTACT, profileModelClass.getContact());
        contentValues.put(DatabaseHelperClass.LOCATION, profileModelClass.getLocation());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(profileModelClass.getId())});
    }

    public void deleteProfile(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}

