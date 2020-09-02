package com.example.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ContactDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contact_db";
    private static final int VERSION = 1;
    public static final String CREAT_TABLE = "CREATE TABLE " + ContractContact.ContractEntry.TABLE_NAME +
            "(" + ContractContact.ContractEntry.CONTACT_ID + " INT," + ContractContact.ContractEntry.NAME + " VARCHAR(50) NOT NULL, " + ContractContact.ContractEntry.EMAIL + " VARCHAR(50) NOT NULL )";
    public static final String DROP_TABLE = "drop table if exists " + ContractContact.ContractEntry.TABLE_NAME;


    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        Log.d("table is", CREAT_TABLE);
        Log.d("database is ", "created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_TABLE);
        Log.d("table is ", "created...");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContact(int id, String name, String email, SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContractContact.ContractEntry.CONTACT_ID, id);
        contentValues.put(ContractContact.ContractEntry.NAME, name);
        contentValues.put(ContractContact.ContractEntry.EMAIL, email);

        sqLiteDatabase.insert(ContractContact.ContractEntry.TABLE_NAME, null, contentValues);
        Log.d("databade operations", "one row inserted");

    }

    public Cursor readContact(SQLiteDatabase database) {
        String[] projections = {ContractContact.ContractEntry.CONTACT_ID, ContractContact.ContractEntry.NAME, ContractContact.ContractEntry.EMAIL};
        Cursor cursor = database.query(ContractContact.ContractEntry.TABLE_NAME, projections, null, null, null, null, null);
        Log.d("cursor ", String.valueOf(cursor));
        return cursor;
    }

    public void updateContact(int id, String email, String name, SQLiteDatabase db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ContractContact.ContractEntry.NAME, "=" + name);
        contentValues.put(ContractContact.ContractEntry.EMAIL, "=" + email);

        String selection = ContractContact.ContractEntry.CONTACT_ID + "=" + id;
        db.update(ContractContact.ContractEntry.TABLE_NAME, contentValues, selection, null);

    }

    public void deleteContact(int id,SQLiteDatabase db){
        String selection=ContractContact.ContractEntry.CONTACT_ID+" = "+id;
        db.delete(ContractContact.ContractEntry.TABLE_NAME,selection,null);
        

    }

}
