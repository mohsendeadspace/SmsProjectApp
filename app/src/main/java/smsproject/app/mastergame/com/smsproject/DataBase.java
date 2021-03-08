package smsproject.app.mastergame.com.smsproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context, "mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE  IF NOT EXISTS person (" +
                "id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
                " phone_num TEXT ," +
                " password TEXT UNIQUE" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
