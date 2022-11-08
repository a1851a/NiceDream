package fju.project.nicedream.ui.main.fragment.setting.vedio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import fju.project.nicedream.R;

public class VedioActivity extends AppCompatActivity {

    private static final String TAG = "VedioActivity";

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
        webview.loadUrl("https://www.youtube.com/playlist?list=PLzytZGo7D8APuHp677_CO6zaWzEXZlzfo");

    }

}