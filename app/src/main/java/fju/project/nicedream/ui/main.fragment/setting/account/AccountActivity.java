package fju.project.nicedream.ui.main.fragment.setting.account;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import fju.project.nicedream.R;

public class AccountActivity extends AppCompatActivity {
    private static final String TAG = "AccountActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

    }
}
