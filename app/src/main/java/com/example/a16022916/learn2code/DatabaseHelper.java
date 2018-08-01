package com.example.a16022916.learn2code;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a16022916.learn2code.LoginApp.User;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyApp.db";
    private static final String TABLE_NAME = "USER";
    private static final int DATABASE_VERSION = 1;
//    private static final String COL0ID = "ID";
    private static final String COL0USERNAME = "username";
    private static final String COL1PASSWORD = "password";
    private static final String COL2PHONENUMBER = "phoneNum";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "("+COL0USERNAME+" TEXT PRIMARY KEY, " + COL1PASSWORD + " TEXT," + COL2PHONENUMBER + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertUser(User user) {

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL0USERNAME, user.getName());
        contentValues.put(COL1PASSWORD, user.getPassword());
        contentValues.put(COL2PHONENUMBER, user.getPhoneNumber());

        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return result;

    }

    public boolean checkUser (String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { COL0USERNAME}, COL0USERNAME + "=?",
                new String[] { String.valueOf(username) }, null, null, null, null);


        if(cursor.moveToFirst()) {
            return true;
        }else{
            return false;
        }
    }

    public User getUser (String username) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { COL0USERNAME,
                        COL1PASSWORD, COL2PHONENUMBER}, COL0USERNAME + "=?",
                new String[] { String.valueOf(username) }, null, null, null, null);


        if(cursor.moveToFirst()) {
            String strName = cursor.getString(0);
            String strPassword = cursor.getString(1);
            int intNumber = cursor.getInt(2);
            User user = new User(strName ,strPassword, intNumber);
            db.close();
            return user;
        }else{
            db.close();
            return null;
        }

    }

    public void updateUser (User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL1PASSWORD, user.getPassword());
        values.put(COL2PHONENUMBER, user.getPhoneNumber());
        String condition = COL0USERNAME + " =?";
        String[] args = {String.valueOf(user.getName())};
        db.update(TABLE_NAME,values,condition,args);
        db.close();
    }

    public void deleteUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, COL0USERNAME + "=?", new String[]{String.valueOf(user.getName())});
        db.close();
    }

    public ArrayList<User> getAllUsers() {

        ArrayList<User> userList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                String strUserName = cursor.getString(0);
                String strUserPassword = cursor.getString(1);
                int intUserNumber = Integer.parseInt(cursor.getString(2));
                User getUser = new User(strUserName,strUserPassword,intUserNumber);
                userList.add(getUser);

            } while (cursor.moveToNext());
        }
        db.close();
        return userList;

    }

//    public ArrayList<Dessert> retreiveDessertsByPrice(double minPrice) {
//        ArrayList<Dessert> dessertList = new ArrayList<>();
//
//        String selectQuery = "SELECT * FROM " + TABLE_NAME +" WHERE PRICE > "+ minPrice;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if(cursor.moveToFirst()){
//            do {
//                int dessertId = cursor.getInt(0);
//                String dessertName = cursor.getString(1);
//                double dessertPrice = cursor.getDouble(2);
//                Dessert getDessert = new User(dessertId,dessertName,dessertPrice);
//                dessertList.add(getDessert);
//
//            } while (cursor.moveToNext());
//        }
//        db.close();
//        return dessertList;
//    }
//
//    public String insertDessert(String name,double price) {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put("name", name);
//        contentValues.put("price", String.valueOf(price));
//
//        long result = db.insert("Desserts",null,contentValues);
//
//        db.close();
//        if (result == 1){
//            return "Success";
//        } else {
//            return "Failed";
//        }
//
//    }

}
