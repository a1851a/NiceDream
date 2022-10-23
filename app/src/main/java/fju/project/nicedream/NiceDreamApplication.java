package fju.project.nicedream;

import android.app.Application;

import com.facebook.stetho.Stetho;

import java.util.Timer;

public class NiceDreamApplication extends Application {

    private static final String TAG = "NiceDreamApplication";

    private static Timer timer = null;

    public static Timer getTimer (){

        timer = new Timer();

        return timer;
    }


}
