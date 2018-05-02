package com.example.p7xxtm1_g.jdsimulate.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by P7XXTM1-G on 2018/4/24.
 */

public class MySQLite extends SQLiteOpenHelper {
    public MySQLite(Context context) {
        super(context, "WangZhongFu.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table ShenFu(id integer primary key autoincrement,name text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
