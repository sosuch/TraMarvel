package kr.co.ezenac.sosuch.tramarvel.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import kr.co.ezenac.sosuch.tramarvel.model.Character;

/**
 * Created by Administrator on 2018-02-09.
 */

public class DbManager extends SQLiteOpenHelper {
    public DbManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE Character (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "location INTEGER, money INTEGER, score INTEGER, product_name TEXT);";

        sqLiteDatabase.execSQL(query);

        sqLiteDatabase.execSQL("Insert into Character Values (null,1,100,0,'없음');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void deleteData(Integer id) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("Delete from Character where id=" + id);
    }

    public void insertData(int location, int money, int score, String product_name) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("Insert into Character Values (null," + location + ","+ money +","
                + score + ",'" + product_name + "');");
    }

    public void saveData(int location, int money, int score, String product_name){
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("Update Character set location = "+ location +";");
        db.execSQL("Update Character set money = "+ money +";");
        db.execSQL("Update Character set score = "+ score +";");
        db.execSQL("Update Character set product_name = '"+ product_name +"';");
    }

    public Character loadData() {
        Character character = null;
        
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Character where id = 1",null);
        Log.d("ksj","1");
        if(cursor.moveToNext()){
            Integer location = cursor.getInt(1);
            Integer money = cursor.getInt(2);
            Integer score = cursor.getInt(3);
            String product_name = cursor.getString(4);

            Log.d("ksj",location + " " + money + " "  + score + " " + product_name);


            character = new Character(location,money,score,product_name);
        }
        return character;
    }
}
