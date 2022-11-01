package fju.project.nicedream.data.util;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fju.project.nicedream.R;

public class DeviceChecker {

    public static final int RequestCameraPermission = 1;
    public static final int RequestStoragePermission =2;


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
                dialog.setTitle("請開啟網路");
                dialog.setMessage("若未開啟，則無法使用此功能。");
                dialog.setPositiveButton("我知道了",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        // TODO Auto-generated method stub
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
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
