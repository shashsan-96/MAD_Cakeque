package com.example.cakeque;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "cake_database";

    //Database table name
    private static final String TABLE_NAME = "ORDERS";

    //Table columns
    public static final String ORDER_ID = "orderId";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String REQUIREMENTS = "requirements";
    public static final String BUDGET = "budget";
    public static final String DELIVERY_DATE = "dDate";
    private SQLiteDatabase sqLiteDatabase;

    //Create database table query
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +"("+ORDER_ID + " INTEGER PRIMARY KEY,"+NAME+" TEXT NOT NULL,"+ADDRESS+" TEXT NOT NULL,"+REQUIREMENTS+" TEXT NOT NULL,"+BUDGET+" TEXT NOT NULL,"+DELIVERY_DATE+" TEXT NOT NULL);";

    //Create DatabaseHelperClass constructor
    public DatabaseHelperClass (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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

    public int getAutoIncrementID(){
        int count=0;
        String id = "Select count(orderId) from ORDERS";
        Cursor cur = getReadableDatabase().rawQuery(id,null);
        if(cur.getCount()>0){
            cur.moveToFirst();
            count = cur.getInt(0);
        }
       cur.close();
        int neworderID = count + 100001;
        return neworderID;
    }

    //Add order data
    public void addOrder(OrderModelClass orderModelClass){

        //Insert order data into the database by passing ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.ORDER_ID, orderModelClass.getOrderId());
        contentValues.put(DatabaseHelperClass.NAME, orderModelClass.getName());
        contentValues.put(DatabaseHelperClass.ADDRESS, orderModelClass.getAddress());
        contentValues.put(DatabaseHelperClass.REQUIREMENTS, orderModelClass.getRequirements());
        contentValues.put(DatabaseHelperClass.BUDGET, orderModelClass.getBudget());
        contentValues.put(DatabaseHelperClass.DELIVERY_DATE, orderModelClass.getdDate());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null, contentValues);
    }

    //Create getOrderList method
    public List<OrderModelClass> getOrderList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<OrderModelClass> storeOrder = new ArrayList<>();

        //Retrieve data database using an object of Cursor class
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int orderId = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String address = cursor.getString(2);
                String requirements = cursor.getString(3);
                String budget = cursor.getString(4);
                String dDate = cursor.getString(5);
                storeOrder.add(new OrderModelClass(orderId, name, address, requirements, budget, dDate));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return storeOrder;
    }

    //Create updateOrder method
    public  void updateOrder(OrderModelClass orderModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME,orderModelClass.getName());
        contentValues.put(DatabaseHelperClass.ADDRESS,orderModelClass.getAddress());
        contentValues.put(DatabaseHelperClass.REQUIREMENTS,orderModelClass.getRequirements());
        contentValues.put(DatabaseHelperClass.BUDGET,orderModelClass.getBudget());
        contentValues.put(DatabaseHelperClass.DELIVERY_DATE,orderModelClass.getdDate());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ORDER_ID + " = ?" , new String[]
                {String.valueOf(orderModelClass.getOrderId())});
    }

    //Create deleteOrder method
    public void deleteOrder(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ORDER_ID + " = ? ", new String[]
                {String.valueOf(id)});
    }
}