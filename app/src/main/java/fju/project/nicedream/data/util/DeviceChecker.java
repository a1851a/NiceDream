package fju.project.nicedream.data.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import java.util.Objects;

import fju.project.nicedream.R;

public class DeviceChecker {

    private static final String TAG = "DeviceChecker";

    /**
     * @param activity
     * @return true: 有網路 , false: 沒網路
     */
    public static boolean CheckInternet(Activity activity) {
        if (Objects.equals(activity, null)) {
            return false;
        }
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (activeNetwork != null) {
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    Log.d(TAG, "checkInternet: " + "Connected to WIFI");
                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    Log.d(TAG, "checkInternet: " + "Connected to Mobile data");
                }
                return true;
            } else {
                Log.d(TAG, "checkInternet: " + "Not connected");
                AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
                dialog.setTitle(R.string.open_internet);
                dialog.setMessage("若未開啟，則無法使用此功能。");
                dialog.setPositiveButton(R.string.got_it,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        // TODO Auto-generated method stub
                    }
                });
                dialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        // TODO Auto-generated method stub
                    }
                });
                dialog.show();
            }
            return false;
        }catch (NullPointerException e){
            return true;
        }
    }

}
