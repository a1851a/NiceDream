package fju.project.nicedream;

import android.app.Application;

import java.util.Timer;

public class NiceDreamApplication extends Application {

    private static final String TAG = "NiceDreamApplication";

    private static Timer timer = null;

    public static Timer getTimer (){

        timer = new Timer();

        return timer;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }
}
