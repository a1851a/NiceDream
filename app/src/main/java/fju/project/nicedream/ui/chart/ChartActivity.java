package fju.project.nicedream.ui.chart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fju.project.nicedream.R;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
}