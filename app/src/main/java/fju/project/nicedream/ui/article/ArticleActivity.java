package fju.project.nicedream.ui.article;

import android.annotation.SuppressLint;
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
import butterknife.OnClick;
import fju.project.nicedream.R;

public class ArticleActivity extends AppCompatActivity {

    private static final String TAG = "ArticleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        WebView webview = (WebView) findViewById(R.id.article_webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://news.google.com/search?for=%E7%9D%A1%E7%9C%A0%E5%91%BC%E5%90%B8%E4%B8%AD%E6%AD%A2%E7%97%87&hl=zh-TW&gl=TW&ceid=TW%3Azh-Hant&v2prv=1");

    }


}
