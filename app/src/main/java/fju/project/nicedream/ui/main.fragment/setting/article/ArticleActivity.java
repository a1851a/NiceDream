package fju.project.nicedream.ui.main.fragment.setting.article;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;
import fju.project.nicedream.data.util.DeviceChecker;

public class ArticleActivity extends AppCompatActivity {

    private static final String TAG = "ArticleActivity";

    @BindView(R.id.article1)
    TextView article1;
    @BindView(R.id.article2)
    TextView article2;
    @BindView(R.id.article3)
    TextView article3;
    @BindView(R.id.article4)
    TextView article4;
    @BindView(R.id.article5)
    TextView article5;
    @BindView(R.id.article6)
    TextView article6;
    @BindView(R.id.article7)
    TextView article7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

        /*
        WebView webview = (WebView) findViewById(R.id.article_webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://news.google.com/search?for=%E7%9D%A1%E7%9C%A0%E5%91%BC%E5%90%B8%E4%B8%AD%E6%AD%A2%E7%97%87&hl=zh-TW&gl=TW&ceid=TW%3Azh-Hant&v2prv=1");
        */

    }

    @OnClick({R.id.article1,R.id.article2,R.id.article3,R.id.article4,R.id.article5,R.id.article6,R.id.article7})
    public void onViewClicked(View view){
        switch (view.getId()) {
            case R.id.article1:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent1 = new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://www.mmh.org.tw/taitam/che_int/index6%20-sleep%20center3%20-%203.html"));
                    startActivity(intent1);
                }
                break;
            case R.id.article2:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent2 = new Intent();
                    intent2.setAction(Intent.ACTION_VIEW);
                    intent2.setData(Uri.parse("https://kb.commonhealth.com.tw/library/162.html#data-10-collapse"));
                    startActivity(intent2);
                }
                break;
            case R.id.article3:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent3 = new Intent();
                    intent3.setAction(Intent.ACTION_VIEW);
                    intent3.setData(Uri.parse("https://www.resmed.tw/zh-tw/consumer/diagnosis-and-treatment/sleep-apnea/what-is-sleep-apnea-and-what-are-the-symptoms"));
                    startActivity(intent3);
                }
                break;
            case R.id.article4:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent4 = new Intent();
                    intent4.setAction(Intent.ACTION_VIEW);
                    intent4.setData(Uri.parse("https://ck.ccgh.com.tw/department_listDetail1162.htm"));
                    startActivity(intent4);
                }
                break;
            case R.id.article5:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent5 = new Intent();
                    intent5.setAction(Intent.ACTION_VIEW);
                    intent5.setData(Uri.parse("https://somnoslim.com.tw/tc/blog1?id=16"));
                    startActivity(intent5);
                }
                break;
            case R.id.article6:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent6= new Intent();
                    intent6.setAction(Intent.ACTION_VIEW);
                    intent6.setData(Uri.parse("https://www.raphaelclinic.com.tw/medical_academy/sleep_apnea_syndrome"));
                    startActivity(intent6);
                }
                break;
            case R.id.article7:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent7= new Intent();
                    intent7.setAction(Intent.ACTION_VIEW);
                    intent7.setData(Uri.parse("https://heho.com.tw/archives/189320"));
                    startActivity(intent7);
                }
                break;
        }
    }
}
