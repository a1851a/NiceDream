package fju.project.nicedream.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLdata extends SQLiteOpenHelper {

    //資料庫
    private final static String DB = "NiceDream.db";
    //資料表
    private final static String TB = "test";
    //版本
    private final static int vs = 1;


    public SQLdata(Context context) {
        //super(context, name, factory, version);
        super(context, DB, null, vs);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //第一部分
        String SQL="CREATE TABLE IF NOT EXISTS "+TB+"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "date VARCHAR(10),time VARCHAR(5),name VARCHAR(50),gender VARCHAR(3),age VARCHAR(20),job VARCHAR(20),revenue VARCHAR(20),hight VARCHAR(20),weight VARCHAR(20))";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL = "DROP TABLE "+TB;
        db.execSQL(SQL);
    }
}
