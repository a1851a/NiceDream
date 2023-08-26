package fju.project.nicedream.ui.rapid_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;
import fju.project.nicedream.data.util.DeviceChecker;
import fju.project.nicedream.databinding.ActivityJudgeBinding;
import fju.project.nicedream.ui.main.fragment.setting.article.ArticleActivity;
import fju.project.nicedream.ui.main.fragment.setting.share.ShareActivity;
import fju.project.nicedream.ui.main.fragment.setting.vedio.VedioActivity;

public class JudgeActivity extends AppCompatActivity {

    ActivityJudgeBinding judgebinding;

    /*
    @BindView(R.id.judge_date)
    TextView judgedate;
    @BindView(R.id.health)
    TextView health;
    @BindView(R.id.good)
    ImageView good;
    @BindView(R.id.unhealth)
    TextView unhealth;
    @BindView(R.id.bad)
    ImageView bad;
    @BindView(R.id.judge_article)
    Button judge_article;
    @BindView(R.id.judge_vedio)
    Button judge_vedio;
    @BindView(R.id.main_good)
    ConstraintLayout main_good;
    @BindView(R.id.main_bad)
    ConstraintLayout main_bad;
    @BindView(R.id.loading)
    TextView loading;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.judge_hosipital)
    Button judge_hosipital;
    */

    private String outcome1;
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_judge);
        judgebinding = ActivityJudgeBinding.inflate(getLayoutInflater());
        setContentView(judgebinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //ButterKnife.bind(this);

        judgebinding.judgeDate.setText(""+ DateFormat.format("yyyy/MM/dd",System.currentTimeMillis()));

        Intent intent = this.getIntent();
        //取得bundle，慢慢拆解從Intent中找到附加的資料
        Bundle bundle1 = intent.getExtras();
        //拆出bundle的內容，key為content
        outcome1 = bundle1.getString("outcome");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                show();
            }
        },3000);

        judgebinding.judgeHosipital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(JudgeActivity.this)){
                    return;
                }
                else {
                    startActivity(new Intent(JudgeActivity.this, HosipitalActivity.class));
                }
            }
        });

        judgebinding.judgeArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(JudgeActivity.this)){
                    return;
                }
                else {
                    startActivity(new Intent(JudgeActivity.this, ArticleActivity.class));
                }
            }
        });

        judgebinding.judgeVedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(JudgeActivity.this)){
                    return;
                }
                else {
                    startActivity(new Intent(JudgeActivity.this, VedioActivity.class));
                }
            }
        });
    }

    /*
    @OnClick({R.id.judge_hosipital,R.id.judge_article,R.id.judge_vedio})
    public void onViwClicked(View view){
        switch (view.getId()) {
            case R.id.judge_hosipital:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    startActivity(new Intent(this, HosipitalActivity.class));
                }
                break;
            case R.id.judge_article:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    startActivity(new Intent(this, ArticleActivity.class));
                }
                break;
            case R.id.judge_vedio:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    startActivity(new Intent(this, VedioActivity.class));
                }
                break;
        }
    }*/

    private void show(){
        judgebinding.progressBar.setVisibility(View.GONE);
        judgebinding.loading.setVisibility(View.INVISIBLE);
        //Toast.makeText(JudgeActivity.this,outcome1,Toast.LENGTH_SHORT).show();
        if ("否".equals(outcome1)){
            judgebinding.mainGood.setVisibility(View.VISIBLE);
        }
        else {
            judgebinding.mainBad.setVisibility(View.VISIBLE);
        }
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
                        judgebinding.judgeDate.setText("" + DateFormat.format("yyyy/MM/dd", System.currentTimeMillis()));
                    }
                });
            }
        };
    }
}