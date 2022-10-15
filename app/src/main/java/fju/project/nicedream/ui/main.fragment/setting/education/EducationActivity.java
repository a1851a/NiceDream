package fju.project.nicedream.ui.main.fragment.setting.education;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import fju.project.nicedream.R;

public class EducationActivity extends AppCompatActivity {

    private static final String TAG = "EducationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        WebView webview = (WebView) findViewById(R.id.vedio_webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://www.youtube.com/results?search_query=%E5%91%BC%E5%90%B8%E4%B8%AD%E6%AD%A2%E7%97%87");

    }
}
