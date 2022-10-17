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
        setContentView(R.layout.activity_education);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        WebView webview = (WebView) findViewById(R.id.education_webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://www.tygh.mohw.gov.tw/?aid=509&pid=74&page_name=detail&iid=945");

    }
}
