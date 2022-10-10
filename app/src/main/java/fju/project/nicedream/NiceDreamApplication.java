package fju.project.nicedream;

import android.app.Application;

import java.util.Timer;

public class NiceDreamApplication extends Application {

    private static Timer timer = null;

    public static Timer getTimer (){

        timer = new Timer();

        return timer;
    }

}
