package fju.project.nicedream.ui.main.fragment.setting.education;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import fju.project.nicedream.R;
import fju.project.nicedream.databinding.ActivityEducationBinding;

public class EducationActivity extends AppCompatActivity {

    private static final String TAG = "EducationActivity";
    ActivityEducationBinding educationbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_education);
        educationbinding = ActivityEducationBinding.inflate(getLayoutInflater());
        setContentView(educationbinding.getRoot());

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //WebView webview = (WebView) findViewById(R.id.education_webview);
        educationbinding.educationWebview.getSettings().setJavaScriptEnabled(true);
        educationbinding.educationWebview.setWebViewClient(new WebViewClient());
        educationbinding.educationWebview.loadUrl("https://www.tygh.mohw.gov.tw/?aid=509&pid=74&page_name=detail&iid=945");
    }
}
