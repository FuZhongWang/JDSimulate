package com.example.p7xxtm1_g.jdsimulate.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by P7XXTM1-G on 2018/4/24.
 */

public class DBHandle {

    private final SQLiteDatabase db;

    public DBHandle(Context context) {
        MySQLite mySQLite = new MySQLite(context);
        db = mySQLite.getReadableDatabase();
    }

    public void insert(){


    }
    public void delete(){


    }
    public void updata(){


    }
    public String query(){

        return "";
    }
}
