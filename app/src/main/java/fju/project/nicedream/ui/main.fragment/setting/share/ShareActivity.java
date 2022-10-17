package fju.project.nicedream.ui.main.fragment.setting.share;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;

import fju.project.nicedream.R;

public class ShareActivity extends AppCompatActivity {

    private static final String TAG = "ShareActivity";

    private ReviewManager manager;
    private ReviewInfo reviewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //activateReviewInfo();
        //startReviewFlow();
    }
/*
    private void activateReviewInfo(){
        manager = ReviewManagerFactory.create(this);
        Task<ReviewInfo> managerInfoTask = manager.requestReviewFlow();
        managerInfoTask.addOnCompleteListener((task)->
        {
            if (task.isSuccessful()){
                reviewInfo = task.getResult();
            }
            else {
                Toast.makeText(this,"錯誤",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startReviewFlow(){
        if (reviewInfo != null){
            Task<Void> flow = manager.launchReviewFlow(this,reviewInfo);
            flow.addOnCompleteListener(task -> {
                Toast.makeText(this,"成功",Toast.LENGTH_SHORT).show();
            });
        }
    }*/
}
