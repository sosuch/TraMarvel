package kr.co.ezenac.sosuch.tramarvel.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-02-09.
 */

public class DbManager extends SQLiteOpenHelper {
    public DbManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREAT TABLE Content (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "city_name TEXT, product_name TEXT, product_price INTEGER, picture TEXT);";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void deleteData(Integer id) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("Delete from Content where id=" + id);
    }

    public void insertData(String city_name, String product_name, int product_price, String picture) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("Insert into Content Values (null,'" + city_name+ "','"+product_name +"',"
        + product_price + ",'" + picture + "');");
    }
}
