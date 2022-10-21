package fju.project.nicedream.ui.rapid_test;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;

public class RapidtestActivity extends AppCompatActivity {

    @BindView(R.id.part1)
    Button part1;
    @BindView(R.id.part2)
    Button part2;
    @BindView(R.id.part3)
    Button part3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapidtest);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);

    }

    @OnClick({R.id.part1,R.id.part2,R.id.part3})
    public void onViewClicked(View view){
        switch (view.getId()) {
            case R.id.part1:
                startActivity(new Intent(this, Part1Activity.class));
                break;
            case R.id.part2:
                Dialog();
                break;
            case R.id.part3:
                Dialog();
                break;
        }
    }

    public void Dialog(){
        AlertDialog.Builder Dialog =new AlertDialog.Builder(RapidtestActivity.this);
        Dialog.setTitle("提示");
        Dialog.setMessage("請從第一部分開始作答");
        Dialog.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(RapidtestActivity.this, Part1Activity.class));
            }
        });
        Dialog.show();
    }



}
