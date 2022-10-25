package fju.project.nicedream.ui.rapid_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import fju.project.nicedream.R;

public class JudgeActivity extends AppCompatActivity {

    @BindView(R.id.judge_date)
    TextView judgedate;
    @BindView(R.id.loading)
    TextView loading;
    @BindView(R.id.progressBar)
    ProgressBar image_loading;

    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judge);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

        judgedate.setText(""+ DateFormat.format("yyyy/MM/dd",System.currentTimeMillis()));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                show();
                loading.setVisibility(View.INVISIBLE);
                image_loading.setVisibility(View.INVISIBLE);
                //判斷
            }
        },5000);

    }

    @Override
    protected void onStart() {
        super.onStart();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        judgedate.setText("" + DateFormat.format("yyyy/MM/dd", System.currentTimeMillis()));
                    }
                });
            }
        };
    }

    private void show() {
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    //禁止使用返回鍵
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            event.startTracking();
        }
        return false;
    }

}