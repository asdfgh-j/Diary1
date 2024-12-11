package com.pikachu.record.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库帮助类，用于管理数据库的创建和版本管理。
 */
public class DBHelper extends SQLiteOpenHelper {

    // 数据库名称和版本
    private static final String DATABASE_NAME = "myDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // 表名和列名
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    /**
     * 构造函数。
     * @param context 上下文对象。
     */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * 创建数据库表。
     * @param db SQLiteDatabase对象。
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建表的SQL语句
        String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT" +
                ")";

        // 执行SQL语句创建表
        db.execSQL(CREATE_TABLE_USERS);
    }

    /**
     * 升级数据库。
     * @param db SQLiteDatabase对象。
     * @param oldVersion 旧版本号。
     * @param newVersion 新版本号。
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 如果旧版本小于新版本，则删除旧表并重新创建
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            onCreate(db);
        }
    }
}