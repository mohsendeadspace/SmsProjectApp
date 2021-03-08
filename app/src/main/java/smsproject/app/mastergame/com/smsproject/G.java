package smsproject.app.mastergame.com.smsproject;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;


public class G extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this.getApplicationContext();

 /*
        database.execSQL("CREATE  TABLE  IF NOT EXISTS person (" +
                "id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE ," +
                " phone_num VARCHAR ," +
                " password VARCHAR " +
                ")");
*/

    }
}