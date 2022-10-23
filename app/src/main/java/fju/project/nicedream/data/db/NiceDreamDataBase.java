package fju.project.nicedream.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NiceDreamDataBase extends SQLiteOpenHelper {

    public static final String DataBase="NiceDream.db";
    public static final int version=1;
    String query1,query2,query3;

    public NiceDreamDataBase(@Nullable Context context) {
        super(context, DataBase, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        query1 = "create table part1 (date1 text primary key,time text,name text ,gender text,age text,job text,revenue text,hight text,weight text)";
        query2 = "create table part2 (date2 text primary key,sleepstarttime text,sumsleeptime text,activitytime text,phonetime text,noise text,comfortable text,text_tirednumber text,tired text)";
        query3 = "create table part2 (date3 text primary key,tolit text,headache text ,shake text,lazy text,dream text,acholic text,dry text,attention text,history text,yourhistory text,pressure text,head text,drug text,surgery text)";
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        query1 = "drop table if exists part1";
        query2 = "drop table if exists part2";
        query3 = "drop table if exists part3";
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        onCreate(db);
    }
}
