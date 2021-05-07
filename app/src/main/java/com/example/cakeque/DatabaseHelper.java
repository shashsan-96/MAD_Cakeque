package com.example.cakeque;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "cake_database";
    //Database Table name
    private static final String TABLE_NAME = "Cake";



    public static final String ID = "id";
    public static final String USERID = "userid";
    public static final String ORDERID = "orderid";
    public static final String PROPOSITION = "proposition";
    public static final String CAKECOST = "cakecost";
    public static final String DELIVERCOST = "delivercost";
    public static final String CONTACTS = "contacts";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + USERID + " TEXT NOT NULL,"
            +ORDERID+" TEXT NOT NULL,"
            +PROPOSITION+" TEXT NOT NULL,"
            +CAKECOST+" TEXT NOT NULL,"
            +DELIVERCOST+" TEXT NOT NULL,"
            +CONTACTS+" TEXT NOT NULL);";
    //Constructor
    public DatabaseHelper (Context context){
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

    //Add Employee Data
    public void addProposal(CakeModel cakeModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.USERID, cakeModel.getUserid());
        contentValues.put(DatabaseHelper.ORDERID, cakeModel.getOrderid());
        contentValues.put(DatabaseHelper.PROPOSITION, cakeModel.getProposition());
        contentValues.put(DatabaseHelper.CAKECOST, cakeModel.getCakecost());
        contentValues.put(DatabaseHelper.DELIVERCOST, cakeModel.getDelivercost());
        contentValues.put(DatabaseHelper.CONTACTS, cakeModel.getContacts());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null,contentValues);
    }

    public List<CakeModel> getProposalList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<CakeModel> storeProposal = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String userid = cursor.getString(1);
                String orderid = cursor.getString(2);
                String proposition = cursor.getString(3);
                String cakecost = cursor.getString(4);
                String delivercost = cursor.getString(5);
                String contacts = cursor.getString(6);
                storeProposal.add(new CakeModel(id,userid, orderid, proposition, cakecost, delivercost,contacts));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeProposal;
    }

    public void updateProposal(CakeModel cakeModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.USERID, cakeModel.getUserid());
        contentValues.put(DatabaseHelper.ORDERID, cakeModel.getOrderid());
        contentValues.put(DatabaseHelper.PROPOSITION, cakeModel.getProposition());
        contentValues.put(DatabaseHelper.CAKECOST, cakeModel.getCakecost());
        contentValues.put(DatabaseHelper.DELIVERCOST, cakeModel.getDelivercost());
        contentValues.put(DatabaseHelper.CONTACTS, cakeModel.getContacts());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(cakeModel.getId())});
    }

    public void deleteProposal(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}

