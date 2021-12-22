package com.les.futuramaagain.futuramaDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.les.futuramaagain.R;

import java.security.PublicKey;

public class FuturamaDataBaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "futurama";
    public static final int DB_VERSION = 1;

    public FuturamaDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDataBaseUsers(db,0, DB_VERSION);
        updateDataBaseHumans(db, 0, DB_VERSION);
        updateDataBaseMutants(db, 0, DB_VERSION);
        updateDataBaseRobots(db, 0, DB_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateDataBaseUsers(db, oldVersion, newVersion);
        updateDataBaseHumans(db, oldVersion, newVersion);
        updateDataBaseMutants(db, oldVersion, newVersion);
        updateDataBaseRobots(db, oldVersion, newVersion);

    }



    public void updateDataBaseUsers(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("CREATE TABLE USERS (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "PASSWORD TEXT)");
    }
    public void updateDataBaseHumans(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("CREATE TABLE HUMANS (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "IMAGE_RESOURCES_ID INTEGER)");
        insertHumanChar(db, "Fry", R.drawable.fry);
        insertHumanChar(db, "Amy", R.drawable.amy);
        insertHumanChar(db, "Scruffy", R.drawable.scruffy);
    }

    public void updateDataBaseMutants(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("CREATE TABLE MUTANTS (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "IMAGE_RESOURCES_ID INTEGER)");
        insertMutantChar(db,"Leela", R.drawable.leela);
        insertMutantChar(db,"Zoidberg", R.drawable.zoidberg);
        insertMutantChar(db,"Kif", R.drawable.kif);
    }

    public void updateDataBaseRobots(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("CREATE TABLE ROBOTS (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "IMAGE_RESOURCES_ID INTEGER)");
        insertRobotChar(db, "Bender", R.drawable.bender);
        insertRobotChar(db, "Roberto", R.drawable.roberto);
        insertRobotChar(db, "Flexo", R.drawable.flexo);
    }

    public static void insertHumanChar(SQLiteDatabase db, String name, int resourcesId){
        ContentValues humansValue = new ContentValues();
        humansValue.put("NAME", name);
        humansValue.put("IMAGE_RESOURCES_ID", resourcesId);
        db.insert("HUMANS", null, humansValue);
    }

    public static void insertMutantChar(SQLiteDatabase db, String name, int resourcesId){
        ContentValues mutantValue = new ContentValues();
        mutantValue.put("NAME", name);
        mutantValue.put("IMAGE_RESOURCES_ID", resourcesId);
        db.insert("MUTANTS", null, mutantValue);
    }

    public static void insertRobotChar(SQLiteDatabase db, String name, int resourcesId){
        ContentValues robotValue = new ContentValues();
        robotValue.put("NAME", name);
        robotValue.put("IMAGE_RESOURCES_ID", resourcesId);
        db.insert("ROBOTS", null, robotValue);
    }


}
