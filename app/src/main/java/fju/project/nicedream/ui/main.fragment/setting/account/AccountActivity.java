package fju.project.nicedream.ui.main.fragment.setting.account;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;
import fju.project.nicedream.data.util.DeviceChecker;
import fju.project.nicedream.ui.login.LoginActivity;
import fju.project.nicedream.ui.rapid_test.RapidtestActivity;

public class AccountActivity extends AppCompatActivity {

    private static final String TAG = "AccountActivity";
    private static final int request_album = 1;
    private static final int request_camera = 2;

    @BindView(R.id.profile)
    ImageView profile;
    @BindView(R.id.album)
    ImageView album;
    @BindView(R.id.camera)
    ImageView camera;
    @BindView(R.id.reset)
    ImageView reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

        //Bundle bundle1 = this.getIntent().getExtras();
        //String Id = bundle.getString("Id");
        //String Email = bundle.getString("Email");
        //String PhotoUrl = bundle1.getString("PhotoUrl");
        //Toast.makeText(this,Id+Email+PhotoUrl,Toast.LENGTH_SHORT).show();

    }

    @OnClick({R.id.album,R.id.camera})
    public void onViwClicked(View view) {
        switch (view.getId()) {
            case R.id.album:
                CheckAlbumPermission();
                break;
            case R.id.camera:
                CheckCameraPermission();
                break;
            case R.id.reset:
                break;
        }
    }

    private void CheckAlbumPermission(){
        int album_permission0 = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int album_permission1 = ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (album_permission0 != PackageManager.PERMISSION_GRANTED &&
                album_permission1 != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},request_album);
        }
        else {
            //獲取權限
        }
    }

    private void CheckCameraPermission(){
        int camera_permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (camera_permission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},request_camera);
        }
        else {
            //獲取權限
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode) {
            case request_album:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 已取得權限
                } else {
                    // 使用者拒絕，顯示對話框告知
                    AlertDialog.Builder AlbumPermissionDialog =new AlertDialog.Builder(this);
                    AlbumPermissionDialog.setTitle("App需要您提供權限");
                    AlbumPermissionDialog.setMessage("App需要您提供權限，才能使用此功能");
                    AlbumPermissionDialog.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //TODO("直接跳Intent到setting")
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getPackageName(), null);
                            intent.setData(uri);
                            startActivity(intent);
                        }
                    });
                    AlbumPermissionDialog.show();
                }
                break;
            case request_camera:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 已取得權限
                } else {
                    // 使用者拒絕，顯示對話框告知
                    AlertDialog.Builder CameraPermissionDialog =new AlertDialog.Builder(this);
                    CameraPermissionDialog.setTitle("App需要您提供權限");
                    CameraPermissionDialog.setMessage("App需要您提供權限，才能使用此功能");
                    CameraPermissionDialog.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //TODO("直接跳Intent到setting")
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getPackageName(), null);
                            intent.setData(uri);
                            startActivity(intent);
                        }
                    });
                    CameraPermissionDialog.show();
                }
            default:
                break;
        }
    }

}
