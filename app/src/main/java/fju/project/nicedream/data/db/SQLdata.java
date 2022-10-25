package fju.project.nicedream.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLdata extends SQLiteOpenHelper {

    //資料庫
    private final static String DB = "NiceDream.db";
    //資料表
    private final static String TB1 = "test1";
    private final static String TB2 = "test2";
    private final static String TB3 = "test3";
    private final static String TB4 = "outcome";
    //版本
    private final static int vs = 1;


    public SQLdata(Context context) {
        //super(context, name, factory, version);
        super(context, DB, null, vs);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL1="CREATE TABLE IF NOT EXISTS "+TB1+"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "date VARCHAR(10),time VARCHAR(5),name VARCHAR(50),gender VARCHAR(3),age VARCHAR(20),job VARCHAR(20),revenue VARCHAR(20),hight VARCHAR(20),weight VARCHAR(20))";
        db.execSQL(SQL1);

        String SQL2="CREATE TABLE IF NOT EXISTS "+TB2+"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "sleepstarttime VARCHAR(20),sleeptime VARCHAR(20),activitytime VARCHAR(20),phonetime VARCHAR(20),noise VARCHAR(20),comfortable VARCHAR(20),tired INTEGER)";
        db.execSQL(SQL2);

        String SQL3="CREATE TABLE IF NOT EXISTS "+TB3+"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "toilt INTEGER,headache INTEGER,shake INTEGER,lazy INTEGER,dream INTEGER,acholic INTEGER,dry INTEGER,attention INTEGER,history VARCHAR(20),yourhistory VARCHAR(20),pressure VARCHAR(20),head VARCHAR(20),drug VARCHAR(20),surgery VARCHAR(20))";
        db.execSQL(SQL3);

        String SQL4="CREATE TABLE IF NOT EXISTS "+TB4+"(id INTEGER PRIMARY KEY AUTOINCREMENT,outcome VARCHAR(5))";
        db.execSQL(SQL4);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL1 = "DROP TABLE "+TB1;
        String SQL2 = "DROP TABLE "+TB2;
        String SQL3 = "DROP TABLE "+TB3;
        String SQL4 = "DROP TABLE "+TB4;
        db.execSQL(SQL1);
        db.execSQL(SQL2);
        db.execSQL(SQL3);
        db.execSQL(SQL4);
    }
}
