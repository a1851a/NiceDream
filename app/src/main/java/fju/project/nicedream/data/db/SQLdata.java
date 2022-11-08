package fju.project.nicedream.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLdata extends SQLiteOpenHelper {

    //資料庫
    private final static String DB = "NiceDream.db";
    //資料表
    private final static String TB1 = "test";
    //版本
    private final static int vs = 1;

    public SQLdata(Context context) {
        //super(context, name, factory, version);
        super(context, DB, null, vs);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*String SQL="CREATE TABLE IF NOT EXISTS "+TB1+"(id INTEGER PRIMARY KEY AUTOINCREMENT,date VARCHAR(10),time VARCHAR(5)," +
                "gender VARCHAR(3),age VARCHAR(20),revenue VARCHAR(20),hight VARCHAR(20),weight VARCHAR(20)," +
                "starttime VARCHAR(20),sumtime VARCHAR(20),activitytime VARCHAR(20),phonetime VARCHAR(20),noise VARCHAR(20),comfortable VARCHAR(20),tired VARCHAR(2)," +
                "toilt VARCHAR(2),headache VARCHAR(2),lazy VARCHAR(2),dream VARCHAR(2),acholic VARCHAR(2),dry VARCHAR(2),attention VARCHAR(2),headacheprogress VARCHAR(2),outcome VARCHAR(2))";
        db.execSQL(SQL);*/

        String SQL="CREATE TABLE IF NOT EXISTS "+TB1+"(id INTEGER PRIMARY KEY AUTOINCREMENT,date VARCHAR(10),outcome VARCHAR(2))";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL = "DROP TABLE "+TB1;
        db.execSQL(SQL);
    }
}
