package fju.project.nicedream.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.MainActivity;
import fju.project.nicedream.R;
import fju.project.nicedream.data.util.DeviceChecker;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";

    @BindView(R.id.login_logo)
    ImageView loginlogo;
    @BindView(R.id.login_title)
    ImageView logintitle;
    @BindView(R.id.login_google)
    ImageView logingoogle;
    @BindView(R.id.login_fb)
    ImageView loginfb;
    @BindView(R.id.login_line)
    ImageView loginline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);


    }



    @OnClick({R.id.login_google,R.id.login_fb,R.id.login_line})
    public void onViewClicked(View view){
        switch (view.getId()) {
            case R.id.login_google:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {

                }
                break;
            case R.id.login_fb:
                if (!DeviceChecker.CheckInternet(this)) {
                    return;
                }
                else {

                }
                break;
            case R.id.login_line:
                if (!DeviceChecker.CheckInternet(this)) {
                    return;
                }
                else {

                }
                break;
        }
    }

    //禁止使用返回鍵
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            event.startTracking();
        }
        return false;
    }
}