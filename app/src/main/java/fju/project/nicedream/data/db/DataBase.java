package fju.project.nicedream.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    //資料庫
    private final static String DateBase ="DateBase";
    //資料表
    private final static String user ="user";
    private final static String sleeptime ="sleeptime";
    private final static String part1 ="part1";
    private final static String part2 ="part2";
    private final static String part3 ="part3";
    //資料欄位
    private final static String col1="";
    //資料庫版本
    private final static int version =2;

    public DataBase(Context context) {
        super(context,DateBase,null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase DateBase) {
        //建立資料表
        /*
        String Table_USER = "CREATE TABLE IF NOT EXISTS "+user+"(_mail VARCHAR(50) PRIMARY KEY,_photouri VARCHAR(100))";
        DateBase.execSQL(Table_USER);
        String Table_SLEEPTIME = "CREATE TABLE IF NOT EXISTS "+sleeptime+"(_mail VARCHAR(50)PRIMARY KEY,_date INTEGER,_time INTEGER,_start INTEGER,_end INTEGER,_sum INTEGER)";
        DateBase.execSQL(Table_SLEEPTIME);
        String Table_PART1 = "CREATE TABLE IF NOT EXISTS "+part1+"(_mail VARCHAR(50)PRIMARY KEY,_date INTEGER,_time INTEGER,_name VARCHAR(10),_gender VARCHAR(3),_age VARCHAR(20),_job VARCHAR(10),_revenue VARCHAR(10),_hight VARCHAR(10),_weight VARCHAR(10))";
        DateBase.execSQL(Table_PART1);
        String Table_PART2 = "CREATE TABLE IF NOT EXISTS "+part2+"(_mail VARCHAR(50)PRIMARY KEY,_date INTEGER,_time INTEGER,_startsleep VARCHAR(10),_sumsleep VARCHAR(10),_activite VARCHAR(10),_phone VARCHAR(10),_noise VARCHAR(10),_comfotable VARCHAR(10),_tired INTEGER)";
        DateBase.execSQL(Table_PART2);
        String Table_PART3 = "CREATE TABLE IF NOT EXISTS "+part3+"(_mail VARCHAR(50)PRIMARY KEY,_date INTEGER,_time INTEGER,_toilt INTEGER,_headache INTEGER,_shake INTEGER,_lazy INTEGER,_dream INTEGER,_achoolic INTEGER,_dry INTEGER,_attention INTERGER,_history VARCHER(10),_yourhistory VARCHAR(10),_pressure VARCHAR(10),_head VARCHAR(10),_drug VARCHAR(5),_surgery VARCHAR(5))";
        DateBase.execSQL(Table_PART3);*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase DateBase, int oldVersion, int newVersion) {
    }
}
