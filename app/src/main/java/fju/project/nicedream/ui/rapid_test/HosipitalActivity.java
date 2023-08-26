package fju.project.nicedream.ui.rapid_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fju.project.nicedream.R;
import fju.project.nicedream.data.util.DeviceChecker;
import fju.project.nicedream.databinding.ActivityHosipitalBinding;
import fju.project.nicedream.ui.main.fragment.setting.article.ArticleActivity;
import fju.project.nicedream.ui.main.fragment.setting.vedio.VedioActivity;

public class HosipitalActivity extends AppCompatActivity {

    ActivityHosipitalBinding hosipitalbinding;

    /*
    @BindView(R.id.hosipital_1)
    TextView hosipital_1;
    @BindView(R.id.hosipital_2)
    TextView hosipital_2;
    @BindView(R.id.hosipital_3)
    TextView hosipital_3;
    @BindView(R.id.hosipital_4)
    TextView hosipital_4;
    @BindView(R.id.hosipital_5)
    TextView hosipital_5;
    @BindView(R.id.hosipital_6)
    TextView hosipital_6;
    @BindView(R.id.hosipital_7)
    TextView hosipital_7;
    @BindView(R.id.hosipital_8)
    TextView hosipital_8;
    @BindView(R.id.hosipital_9)
    TextView hosipital_9;
    @BindView(R.id.hosipital_10)
    TextView hosipital_10;
    @BindView(R.id.hosipital_11)
    TextView hosipital_11;
    @BindView(R.id.hosipital_12)
    TextView hosipital_12;
    @BindView(R.id.hosipital_13)
    TextView hosipital_13;
    @BindView(R.id.hosipital_14)
    TextView hosipital_14;
    @BindView(R.id.hosipital_15)
    TextView hosipital_15;
    @BindView(R.id.hosipital_16)
    TextView hosipital_16;
    @BindView(R.id.hosipital_17)
    TextView hosipital_17;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hosipital);
        hosipitalbinding = ActivityHosipitalBinding.inflate(getLayoutInflater());
        setContentView(hosipitalbinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //ButterKnife.bind(this);

        hosipitalbinding.hosipital1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent1 = new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://www.ntuh.gov.tw/SLP/Index.action"));
                    startActivity(intent1);
                }
            }
        });

        hosipitalbinding.hosipital2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent2 = new Intent();
                    intent2.setAction(Intent.ACTION_VIEW);
                    intent2.setData(Uri.parse("https://www.tmuh.org.tw/team/team/57"));
                    startActivity(intent2);
                }
            }
        });

        hosipitalbinding.hosipital3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent3 = new Intent();
                    intent3.setAction(Intent.ACTION_VIEW);
                    intent3.setData(Uri.parse("https://vghcsm.vghtpe.gov.tw/sleep/sle_04.html"));
                    startActivity(intent3);
                }
            }
        });
        hosipitalbinding.hosipital4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)) {
                    return;
                } else {
                    Intent intent4=new Intent();
                    intent4.setAction(Intent.ACTION_VIEW);
                    intent4.setData(Uri.parse("https://www.skh.org.tw/skh/1fa449a615.html"));
                    startActivity(intent4);
                }
            }
        });
        hosipitalbinding.hosipital5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent5 = new Intent();
                    intent5.setAction(Intent.ACTION_VIEW);
                    intent5.setData(Uri.parse("https://www1.cgmh.org.tw/sleepcenterkel/"));
                    startActivity(intent5);
                }
            }
        });
        hosipitalbinding.hosipital6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent6 = new Intent();
                    intent6.setAction(Intent.ACTION_VIEW);
                    intent6.setData(Uri.parse("https://taipei.tzuchi.com.tw/category/%E7%9D%A1%E7%9C%A0%E9%9A%9C%E7%A4%99%E6%B2%BB%E7%99%82%E5%9C%98%E9%9A%8A/"));
                    startActivity(intent6);
                }
            }
        });
        hosipitalbinding.hosipital7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent7 = new Intent();
                    intent7.setAction(Intent.ACTION_VIEW);
                    intent7.setData(Uri.parse("https://www.mmh.org.tw/depwebpage.php?id=13"));
                    startActivity(intent7);
                }
            }
        });
        hosipitalbinding.hosipital8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent8 = new Intent();
                    intent8.setAction(Intent.ACTION_VIEW);
                    intent8.setData(Uri.parse("https://www.cmuh.cmu.edu.tw/Department/Detail?depid=127"));
                    startActivity(intent8);
                }
            }
        });
        hosipitalbinding.hosipital9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent9 = new Intent();
                    intent9.setAction(Intent.ACTION_VIEW);
                    intent9.setData(Uri.parse("https://taichungsub.tzuchi.com.tw/54"));
                    startActivity(intent9);
                }
            }
        });
        hosipitalbinding.hosipital10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent10 = new Intent();
                    intent10.setAction(Intent.ACTION_VIEW);
                    intent10.setData(Uri.parse("http://www2.cch.org.tw/layout_4/index.aspx?id=7340"));
                    startActivity(intent10);
                }
            }
        });
        hosipitalbinding.hosipital11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent11 = new Intent();
                    intent11.setAction(Intent.ACTION_VIEW);
                    intent11.setData(Uri.parse("https://www1.cgmh.org.tw/sleepcenterjia/"));
                    startActivity(intent11);
                }
            }
        });
        hosipitalbinding.hosipital12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent12 = new Intent();
                    intent12.setAction(Intent.ACTION_VIEW);
                    intent12.setData(Uri.parse("https://www.tnhosp.mohw.gov.tw/page.asp?orcaid=%7B1E3B93AB-A62E-441D-8450-A3A0F3D5F58A%7D"));
                    startActivity(intent12);
                }
            }
        });
        hosipitalbinding.hosipital13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent13 = new Intent();
                    intent13.setAction(Intent.ACTION_VIEW);
                    intent13.setData(Uri.parse("https://mtmptech.com/sleep-check-location/%E9%AB%98%E9%9B%84%E9%86%AB%E5%AD%B8%E5%A4%A7%E5%AD%B8%E9%99%84%E8%A8%AD%E4%B8%AD%E5%92%8C%E7%B4%80%E5%BF%B5%E9%86%AB%E9%99%A2"));
                    startActivity(intent13);
                }
            }
        });
        hosipitalbinding.hosipital14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent14 = new Intent();
                    intent14.setAction(Intent.ACTION_VIEW);
                    intent14.setData(Uri.parse("https://edhg.edah.org.tw/Center_3/EC/50"));
                    startActivity(intent14);
                }
            }
        });
        hosipitalbinding.hosipital15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent15 = new Intent();
                    intent15.setAction(Intent.ACTION_VIEW);
                    intent15.setData(Uri.parse("https://www1.cgmh.org.tw/intr/intr4/c8130/sleep/index.asp"));
                    startActivity(intent15);
                }
            }
        });
        hosipitalbinding.hosipital16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent16 = new Intent();
                    intent16.setAction(Intent.ACTION_VIEW);
                    intent16.setData(Uri.parse("https://www.pohai.org.tw/department_detail.php?PKey=421"));
                    startActivity(intent16);
                }
            }
        });
        hosipitalbinding.hosipital17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DeviceChecker.CheckInternet(HosipitalActivity.this)){
                    return;
                }
                else {
                    Intent intent17 = new Intent();
                    intent17.setAction(Intent.ACTION_VIEW);
                    intent17.setData(Uri.parse("https://hlm.tzuchi.com.tw/pulm/index.php/2017-05-31-09-19-15"));
                    startActivity(intent17);
                }
            }
        });
    }

    /*
    @OnClick({R.id.hosipital_1,R.id.hosipital_2,R.id.hosipital_3,R.id.hosipital_4,R.id.hosipital_5
            ,R.id.hosipital_6,R.id.hosipital_7,R.id.hosipital_8,R.id.hosipital_9,R.id.hosipital_10
            ,R.id.hosipital_11,R.id.hosipital_12,R.id.hosipital_13,R.id.hosipital_14,R.id.hosipital_15
            ,R.id.hosipital_16,R.id.hosipital_17})
    public void onViwClicked(View view){
        switch (view.getId()) {
            case R.id.hosipital_1:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent1 = new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://www.ntuh.gov.tw/SLP/Index.action"));
                    startActivity(intent1);
                }
                break;
            case R.id.hosipital_2:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent2 = new Intent();
                    intent2.setAction(Intent.ACTION_VIEW);
                    intent2.setData(Uri.parse("https://www.tmuh.org.tw/team/team/57"));
                    startActivity(intent2);
                }
                break;
            case R.id.hosipital_3:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent3 = new Intent();
                    intent3.setAction(Intent.ACTION_VIEW);
                    intent3.setData(Uri.parse("https://vghcsm.vghtpe.gov.tw/sleep/sle_04.html"));
                    startActivity(intent3);
                }
                break;
            case R.id.hosipital_4:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent4 = new Intent();
                    intent4.setAction(Intent.ACTION_VIEW);
                    intent4.setData(Uri.parse("https://www.skh.org.tw/skh/1fa449a615.html"));
                    startActivity(intent4);
                }
                break;
            case R.id.hosipital_5:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent5 = new Intent();
                    intent5.setAction(Intent.ACTION_VIEW);
                    intent5.setData(Uri.parse("https://www1.cgmh.org.tw/sleepcenterkel/"));
                    startActivity(intent5);
                }
                break;
            case R.id.hosipital_6:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent6 = new Intent();
                    intent6.setAction(Intent.ACTION_VIEW);
                    intent6.setData(Uri.parse("https://taipei.tzuchi.com.tw/category/%E7%9D%A1%E7%9C%A0%E9%9A%9C%E7%A4%99%E6%B2%BB%E7%99%82%E5%9C%98%E9%9A%8A/"));
                    startActivity(intent6);
                }
                break;
            case R.id.hosipital_7:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent7 = new Intent();
                    intent7.setAction(Intent.ACTION_VIEW);
                    intent7.setData(Uri.parse("https://www.mmh.org.tw/depwebpage.php?id=13"));
                    startActivity(intent7);
                }
                break;
            case R.id.hosipital_8:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent8 = new Intent();
                    intent8.setAction(Intent.ACTION_VIEW);
                    intent8.setData(Uri.parse("https://www.cmuh.cmu.edu.tw/Department/Detail?depid=127"));
                    startActivity(intent8);
                }
                break;
            case R.id.hosipital_9:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent9 = new Intent();
                    intent9.setAction(Intent.ACTION_VIEW);
                    intent9.setData(Uri.parse("https://taichungsub.tzuchi.com.tw/54"));
                    startActivity(intent9);
                }
                break;
            case R.id.hosipital_10:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent10 = new Intent();
                    intent10.setAction(Intent.ACTION_VIEW);
                    intent10.setData(Uri.parse("http://www2.cch.org.tw/layout_4/index.aspx?id=7340"));
                    startActivity(intent10);
                }
                break;
            case R.id.hosipital_11:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent11 = new Intent();
                    intent11.setAction(Intent.ACTION_VIEW);
                    intent11.setData(Uri.parse("https://www1.cgmh.org.tw/sleepcenterjia/"));
                    startActivity(intent11);
                }
                break;
            case R.id.hosipital_12:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent12 = new Intent();
                    intent12.setAction(Intent.ACTION_VIEW);
                    intent12.setData(Uri.parse("https://www.tnhosp.mohw.gov.tw/page.asp?orcaid=%7B1E3B93AB-A62E-441D-8450-A3A0F3D5F58A%7D"));
                    startActivity(intent12);
                }
                break;
            case R.id.hosipital_13:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent13 = new Intent();
                    intent13.setAction(Intent.ACTION_VIEW);
                    intent13.setData(Uri.parse("https://mtmptech.com/sleep-check-location/%E9%AB%98%E9%9B%84%E9%86%AB%E5%AD%B8%E5%A4%A7%E5%AD%B8%E9%99%84%E8%A8%AD%E4%B8%AD%E5%92%8C%E7%B4%80%E5%BF%B5%E9%86%AB%E9%99%A2"));
                    startActivity(intent13);
                }
                break;
            case R.id.hosipital_14:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent14 = new Intent();
                    intent14.setAction(Intent.ACTION_VIEW);
                    intent14.setData(Uri.parse("https://edhg.edah.org.tw/Center_3/EC/50"));
                    startActivity(intent14);
                }
                break;
            case R.id.hosipital_15:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent15 = new Intent();
                    intent15.setAction(Intent.ACTION_VIEW);
                    intent15.setData(Uri.parse("https://www1.cgmh.org.tw/intr/intr4/c8130/sleep/index.asp"));
                    startActivity(intent15);
                }
                break;
            case R.id.hosipital_16:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent16 = new Intent();
                    intent16.setAction(Intent.ACTION_VIEW);
                    intent16.setData(Uri.parse("https://www.pohai.org.tw/department_detail.php?PKey=421"));
                    startActivity(intent16);
                }
                break;
            case R.id.hosipital_17:
                if (!DeviceChecker.CheckInternet(this)){
                    return;
                }
                else {
                    Intent intent17 = new Intent();
                    intent17.setAction(Intent.ACTION_VIEW);
                    intent17.setData(Uri.parse("https://hlm.tzuchi.com.tw/pulm/index.php/2017-05-31-09-19-15"));
                    startActivity(intent17);
                }
                break;
        }
    }
    */
}