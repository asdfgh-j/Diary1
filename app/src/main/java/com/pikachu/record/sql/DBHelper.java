package com.pikachu.record.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;
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
    public boolean checkUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { "id" };
        String selection = "username = ?";
        String[] selectionArgs = { username };
        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public long insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        return db.insert("users", null, values);
    }
    /**
     * 检查用户名和密码是否匹配
     * @param username 用户名
     * @param password 密码
     * @return 如果找到匹配的用户返回 true，否则返回 false
     */
    public boolean loginUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { COLUMN_ID };
        String selection = COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }


}